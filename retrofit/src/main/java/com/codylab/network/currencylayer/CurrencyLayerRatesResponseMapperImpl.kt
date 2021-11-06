package com.codylab.network.currencylayer

import com.codylab.domain.Rate
import com.codylab.repository.CurrencyRepository

internal class CurrencyLayerRatesResponseMapperImpl(
    val currencyRepository: CurrencyRepository
) : LiveRatesResponseMapper {
    override fun mapToRates(response: LiveRatesResponse): List<Rate> {
        return response.quotes?.entries?.map {
            val fromCurrencyCode = it.key.substring(0..2)
            val toCurrencyCode = it.key.substring(3..5)
            val toCurrency = currencyRepository.getCurrency(toCurrencyCode) ?: return@map null
            val fromCurrency = currencyRepository.getCurrency(fromCurrencyCode) ?: return@map null
            val rate = it.value
            Rate(fromCurrency, toCurrency, rate)
        }?.filterNotNull() ?: listOf()
    }
}