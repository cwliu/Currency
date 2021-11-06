package com.codylab.currency.converter.usecase

import com.codylab.currency.converter.ConverterUIState
import com.codylab.currency.converter.DisplayCurrency

interface ConvertUseCase {
    suspend fun loadInitialUIState(): ConverterUIState
    suspend fun saveSelectedCurrency(code: String)
    suspend fun calculateRates(amount: Float): List<DisplayCurrency>
    suspend fun refreshRates(): List<DisplayCurrency>
}