package com.codylab.repository.datasource

import com.codylab.domain.Rate

interface WritableRateDataSource {
    suspend fun addRates(rates: List<Rate>)
    suspend fun delete()
}