package com.codylab.currency.converter

import com.codylab.domain.Rate

data class ConverterUIState(
    val amount: Float,
    val currencies: List<ConversionUIModel>,
    val currencyDropDown: List<String>,
    val selectedDropDownIndex: Int,
    val rates: List<Rate>,
    val isLoading: Boolean
) {
    companion object {
        val DEFAULT: ConverterUIState = ConverterUIState(
            amount = 0.0f,
            selectedDropDownIndex = 0,
            currencies = listOf(),
            currencyDropDown = listOf(),
            rates = listOf(),
            isLoading = false
        )
    }
}
