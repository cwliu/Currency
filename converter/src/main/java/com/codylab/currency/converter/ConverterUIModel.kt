package com.codylab.currency.converter

import com.codylab.domain.Rate
import com.codylab.domain.SelectedCurrency

data class ConverterUIState(
    val amount: Float,
    val selectedCurrency: SelectedCurrency?,
    val currencies: List<DisplayCurrency>,
    val rates: List<Rate>,
    val isLoading: Boolean
) {
    companion object {
        val DEFAULT: ConverterUIState = ConverterUIState(
            amount = 0.0f,
            selectedCurrency = null,
            currencies = listOf(),
            rates = listOf(),
            isLoading = false
        )
    }
}
