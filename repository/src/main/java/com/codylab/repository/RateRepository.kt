package com.codylab.repository

import com.codylab.domain.Rate
import kotlinx.coroutines.flow.Flow


interface RateRepository {
    suspend fun getRates(): Flow<List<Rate>>
    suspend fun refreshRateIfNeed()
}