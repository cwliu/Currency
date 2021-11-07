package com.codylab.network

import com.codylab.domain.Rate
import com.codylab.network.currencylayer.*
import com.codylab.repository.datasource.ReadableRateDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext


internal class CurrencyLayerDataSource(
    private val currencyLayerApi: CurrencyLayerApi,
    private val liveRatesResponseMapper: LiveRatesResponseMapper,
    private val ioDispatcher: CoroutineDispatcher
) : ReadableRateDataSource {
    override suspend fun getRates(): Flow<List<Rate>> = withContext(ioDispatcher) {
        val key = BuildConfig.CURRENCYLAYER_KEY
        val response = currencyLayerApi.liveRates(key)
        flowOf(liveRatesResponseMapper.mapToRates(response))
    }
}