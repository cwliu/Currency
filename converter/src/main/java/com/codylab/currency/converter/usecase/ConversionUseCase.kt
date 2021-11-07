package com.codylab.currency.converter.usecase

import com.codylab.domain.Conversion

interface ConversionUseCase {
    suspend fun calculateRates(amount: Float): List<Conversion>
}