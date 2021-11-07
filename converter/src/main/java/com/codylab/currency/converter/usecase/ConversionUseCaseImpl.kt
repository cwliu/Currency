package com.codylab.currency.converter.usecase

import com.codylab.currency.converter.ConverterUIState
import com.codylab.currency.converter.ConversionUIModel
import com.codylab.domain.*
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.ExchangeRateRepository
import com.codylab.repository.datasource.Settings

class ConversionUseCaseImpl(
    private val exchangeRateRepository: ExchangeRateRepository,
    private val currencyRepository: CurrencyRepository,
    private val settings: Settings
) : ConversionUseCase {
    override suspend fun loadInitialUIState(): ConverterUIState {
        val selectedCurrency =
            settings.getSelectedCurrency() ?: SelectedCurrency(DEFAULT_CURRENCY_CODE)
        val selectedCurrencyIndex = currencyRepository.getAllCurrencies().withIndex()
            .first { it.value.code == selectedCurrency.code }

        return ConverterUIState.DEFAULT.copy(
            selectedDropDownIndex = selectedCurrencyIndex.index,
            isLoading = true,
            currencies = currencyRepository.getAllCurrencies().map {
                ConversionUIModel(it.code, it.name, 0.0f)
            }
        )
    }

    override suspend fun refreshRates(): List<ConversionUIModel> {
        return currencyRepository.getAllCurrencies().map {
            val convertedAmount = 1.0f
            ConversionUIModel(it.code, it.name, convertedAmount)
        }
    }

    override suspend fun saveSelectedCurrency(code: String) {
        settings.setSelectedCurrency(SelectedCurrency(code))
    }

    override suspend fun calculateRates(amount: Float): List<ConversionUIModel> {
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

    override suspend fun getCurrencies(): List<Currency> {
        return currencyRepository.getAllCurrencies()
    }
}