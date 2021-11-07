package com.codylab.repository

import com.codylab.domain.Rate
import com.codylab.repository.datasource.ReadableRateDataSource
import com.codylab.repository.datasource.SettingsRepository
import com.codylab.repository.datasource.TimeProvider
import com.codylab.repository.datasource.WritableRateDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

internal class RateRepositoryImpl(
    private val localRateReader: ReadableRateDataSource,
    private val localRateWriter: WritableRateDataSource,
    private val apiRateReader: ReadableRateDataSource,
    private val settingsRepository: SettingsRepository,
    private val timeProvider: TimeProvider,
    private val ioDispatcher: CoroutineDispatcher
) : RateRepository {
    override suspend fun getRates(): Flow<List<Rate>> {
        return localRateReader.getRates()
    }

    override suspend fun refreshRateIfNeed() = withContext(ioDispatcher) {
        if (isRateStale()) {
            val rates = apiRateReader.getRates().first()
            localRateWriter.delete()
            localRateWriter.addRates(rates)
            if (rates.isNotEmpty()) {
                settingsRepository.setLastUpdatedTime(timeProvider.now())
            }
        }
    }

    private suspend fun isRateStale(): Boolean {
//        val lastUpdateTime = settingsRepository.getLastUpdatedTime()
        val lastUpdateTime = 0
        val now = timeProvider.now()
        return now - lastUpdateTime > REFRESH_TIME_IN_MIN * 60 * 1000
    }

    companion object {
        const val REFRESH_TIME_IN_MIN = 30
    }
}