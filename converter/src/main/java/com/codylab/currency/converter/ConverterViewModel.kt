package com.codylab.currency.converter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codylab.currency.converter.usecase.ConversionUseCase
import com.codylab.domain.Conversion
import com.codylab.domain.Currency
import com.codylab.domain.DEFAULT_CURRENCY
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.RateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val conversionUseCase: ConversionUseCase,
    private val rateRepository: RateRepository,
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    private val _currencyList = MutableStateFlow<List<Currency>>(listOf())
    val currencyList: StateFlow<List<Currency>>
        get() = _currencyList

    private val _selectedCurrency = MutableStateFlow(DEFAULT_CURRENCY)
    val selectedCurrency: StateFlow<Currency>
        get() = _selectedCurrency

    private val _amount = MutableStateFlow(1000f)
    val amount: StateFlow<Float>
        get() = _amount

    private val _conversionList = MutableStateFlow<List<Conversion>>(listOf())
    val conversionList: StateFlow<List<Conversion>>
        get() = _conversionList

    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.e(ConverterViewModel::class.simpleName, exception.localizedMessage ?: "")
        exception.localizedMessage?.let {
            viewModelScope.launch {
                _message.emit(it)
                delay(3500)
                _message.emit("")
            }
        }
    }

    fun onLoad() {
        _currencyList.value = currencyRepository.getCurrencies()
        viewModelScope.launch(handler) {
            rateRepository.refreshRateIfNeed()
            _conversionList.value =
                conversionUseCase.calculateRates(selectedCurrency.value, _amount.value)
        }
    }

    fun onAmountUpdate(amount: Float) {
        _amount.value = amount
        viewModelScope.launch(handler) {
            _conversionList.value = conversionUseCase.calculateRates(selectedCurrency.value, amount)
        }
    }

    fun onCurrencySelect(currency: Currency) {
        _selectedCurrency.value = currency
        viewModelScope.launch(handler) {
            _conversionList.value = conversionUseCase.calculateRates(currency, _amount.value)
        }
    }
}

