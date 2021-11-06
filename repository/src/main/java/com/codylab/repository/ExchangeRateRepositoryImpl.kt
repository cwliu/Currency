package com.codylab.repository

import com.codylab.domain.Rate
import com.codylab.repository.datasource.RateDataSource
import com.codylab.repository.datasource.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

internal class ExchangeRateRepositoryImpl(
    private val networkRateDataSource: RateDataSource,
    private val settingsDataSource: Settings
) : ExchangeRateRepository {
    override suspend fun getRates(): Flow<List<Rate>> {
        val rates = networkRateDataSource.getRates().first()
        return flow {
            emit(rates)
        }
    }
}