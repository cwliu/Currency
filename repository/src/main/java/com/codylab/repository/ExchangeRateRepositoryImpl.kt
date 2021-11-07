package com.codylab.repository

import com.codylab.domain.Rate
import com.codylab.repository.datasource.RateDataSource
import com.codylab.repository.datasource.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

internal class ExchangeRateRepositoryImpl(
    private val networkRateDataSource: RateDataSource,
    private val settingsRepositoryDataSource: SettingsRepository
) : ExchangeRateRepository {
    override suspend fun getRates(): Flow<List<Rate>> {
        val rates = networkRateDataSource.getRates().first()
        return flow {
            emit(rates)
        }
    }
}