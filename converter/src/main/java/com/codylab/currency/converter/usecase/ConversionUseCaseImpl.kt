package com.codylab.currency.converter.usecase

import com.codylab.domain.*
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.RateRepository
import kotlinx.coroutines.flow.first

class ConversionUseCaseImpl(
    private val currencyRepository: CurrencyRepository,
    private val rateRepository: RateRepository
) : ConversionUseCase {

    override suspend fun calculateRates(sourceCurrency: Currency, amount: Float): List<Conversion> {
        val rates = rateRepository.getRates().first()

        val hashMap = hashMapOf<Pair<Currency, Currency>, Float>()
        rates.forEach {
            hashMap[Pair(it.from, it.to)] = it.value
        }
        hashMap[Pair(USD_CURRENCY, USD_CURRENCY)] = 1.0f

        return currencyRepository.getCurrencies().mapNotNull { targetCurrency ->
            val sourceRate = hashMap[Pair(USD_CURRENCY, sourceCurrency)]
            val targetRate = hashMap[Pair(USD_CURRENCY, targetCurrency)]
            if (sourceRate == null || targetRate == null) {
                return@mapNotNull null
            }

            val convertRate = (1 / sourceRate) * targetRate
            val convertedAmount = amount * convertRate
            Conversion(convertedAmount, Rate(sourceCurrency, targetCurrency, convertRate))
        }
    }
}