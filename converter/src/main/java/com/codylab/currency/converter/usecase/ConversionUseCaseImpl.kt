package com.codylab.currency.converter.usecase

import com.codylab.domain.*
import com.codylab.repository.CurrencyRepository

class ConversionUseCaseImpl(
    private val currencyRepository: CurrencyRepository
) : ConversionUseCase {

    override suspend fun calculateRates(amount: Float): List<Conversion> {
//        val hashMap = hashMapOf<CurrencyPair, Rate>()
//        val rates = exchangeRateRepository.getRates().first()
//        for (rate in rates) {
//            hashMap[CurrencyPair(rate.from, rate.to)] = rate
//        }
//
//        return currencyRepository.getAllCurrencies().map {
//            ConversionUIModel(it.code, it.name, 1.0f)
//        }
        return listOf()
    }
}