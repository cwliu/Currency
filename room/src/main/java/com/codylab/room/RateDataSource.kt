package com.codylab.room

import com.codylab.domain.Rate as DomainRate
import com.codylab.room.Rate as RoomRate
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.datasource.ReadableRateDataSource
import com.codylab.repository.datasource.WritableRateDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class RoomRateDataSource(
    private val appDataBase: AppDateBase,
    private val currencyRepository: CurrencyRepository
) : ReadableRateDataSource, WritableRateDataSource {
    override suspend fun getRates(): Flow<List<DomainRate>> {
        return appDataBase.rateDao().getAll().map { mapToDomainRate(it) }
    }

    override suspend fun addRates(rates: List<DomainRate>) {
        appDataBase.rateDao().insertAll(*mapToRoomRate(rates).toTypedArray())
    }

    override suspend fun delete() {
        appDataBase.rateDao().deleteAll()
    }

    private fun mapToDomainRate(roomRates: List<RoomRate>): List<DomainRate> {
        return roomRates.mapNotNull { roomRate ->
            val from = currencyRepository.lookupCurrency(roomRate.from)
            val to = currencyRepository.lookupCurrency(roomRate.to)
            val rate = roomRate.value
            if (from == null || to == null) {
                return@mapNotNull null
            }
            DomainRate(from, to, rate)
        }
    }

    private fun mapToRoomRate(domainRates: List<DomainRate>): List<RoomRate> {
        return domainRates.map { domainRate ->
            RoomRate(domainRate.from.code, domainRate.to.code, domainRate.value)
        }
    }
}