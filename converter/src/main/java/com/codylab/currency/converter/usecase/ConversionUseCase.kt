package com.codylab.currency.converter.usecase

import com.codylab.domain.Conversion
import com.codylab.domain.Currency

interface ConversionUseCase {
    suspend fun calculateRates(currency: Currency, amount: Float): List<Conversion>
}