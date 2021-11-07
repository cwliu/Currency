package com.codylab.repository.datasource

import com.codylab.domain.Rate
import kotlinx.coroutines.flow.Flow

interface ReadableRateDataSource {
    suspend fun getRates(): Flow<List<Rate>>
}