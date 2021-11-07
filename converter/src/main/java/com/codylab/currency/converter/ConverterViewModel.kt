package com.codylab.currency.converter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codylab.currency.converter.usecase.ConversionUseCase
import com.codylab.domain.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val conversionUseCase: ConversionUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ConverterUIState.DEFAULT)
    val uiState: StateFlow<ConverterUIState> = _uiState
    private val _events = MutableSharedFlow<Event>()
    val events = _events.asSharedFlow()

    private val handler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch {
            _events.emit(Event(exception.localizedMessage ?: ""))
        }
    }

    fun onLoad() {
        viewModelScope.launch(handler) {
            _uiState.value = uiState.value.copy(
                isLoading = true
            )
            val currencies = conversionUseCase.getCurrencies()

            _uiState.value = uiState.value.copy(
                currencyDropDown = currencies.map { "[ ${it.code} ] ${it.name}" },
                isLoading = false
            )
        }
    }

    fun onAmountUpdate(amount: Float) {
    }

    fun onCurrencySelect(currency: Currency) {
    }
}

