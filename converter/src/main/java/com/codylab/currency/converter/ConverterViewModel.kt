package com.codylab.currency.converter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codylab.currency.converter.usecase.ConvertUseCase
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
    private val convertUseCase: ConvertUseCase
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

            val currencies = convertUseCase.refreshRates()

            _uiState.value = uiState.value.copy(
                currencies = currencies,
                isLoading = false
            )
        }
    }

    suspend fun onAmountChanged(amount: Float) {
        val currencies = convertUseCase.calculateRates(amount)
        _uiState.value = uiState.value.copy(
            currencies = currencies
        )
    }

    suspend fun onCurrencySelected(currencyCode: String) {
        val currentAmount = _uiState.value.amount
        convertUseCase.saveSelectedCurrency(currencyCode)
        val currencies = convertUseCase.calculateRates(currentAmount)
        _uiState.value = uiState.value.copy(
            currencies = currencies
        )
    }
}

