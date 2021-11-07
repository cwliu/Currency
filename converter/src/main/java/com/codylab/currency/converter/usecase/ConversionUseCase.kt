package com.codylab.currency.converter.usecase

import com.codylab.currency.converter.ConverterUIState
import com.codylab.currency.converter.ConversionUIModel
import com.codylab.domain.Currency

interface ConversionUseCase {
    suspend fun loadInitialUIState(): ConverterUIState
    suspend fun saveSelectedCurrency(code: String)
    suspend fun refreshRates(): List<ConversionUIModel>
    suspend fun calculateRates(amount: Float): List<ConversionUIModel>
    suspend fun getCurrencies(): List<Currency>
}