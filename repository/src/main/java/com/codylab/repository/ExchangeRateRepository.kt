package com.codylab.repository

import com.codylab.domain.Rate
import kotlinx.coroutines.flow.Flow


interface ExchangeRateRepository {
    suspend fun getRates(): Flow<List<Rate>>
}