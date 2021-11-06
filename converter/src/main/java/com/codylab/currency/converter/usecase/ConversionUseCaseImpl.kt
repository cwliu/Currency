package com.codylab.currency.converter.usecase

import com.codylab.currency.converter.ConverterUIState
import com.codylab.currency.converter.DisplayCurrency
import com.codylab.domain.CurrencyPair
import com.codylab.domain.DEFAULT_CURRENCY_CODE
import com.codylab.domain.Rate
import com.codylab.domain.SelectedCurrency
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.ExchangeRateRepository
import com.codylab.repository.datasource.Settings
import kotlinx.coroutines.flow.first

class ConversionUseCaseImpl(
    private val exchangeRateRepository: ExchangeRateRepository,
    private val currencyRepository: CurrencyRepository,
    private val settings: Settings
) : ConvertUseCase {
    override suspend fun loadInitialUIState(): ConverterUIState {
        val selectedCurrency =
            settings.getSelectedCurrency() ?: SelectedCurrency(DEFAULT_CURRENCY_CODE)

        return ConverterUIState.DEFAULT.copy(
            selectedCurrency = selectedCurrency,
            isLoading = true,
            currencies = currencyRepository.getAllCurrencies().map {
                DisplayCurrency(it.code, it.name, 0.0f)
            }
        )
    }

    override suspend fun refreshRates(): List<DisplayCurrency> {
        return currencyRepository.getAllCurrencies().map {
            val convertedAmount = 1.0f
            DisplayCurrency(it.code, it.name, convertedAmount)
        }
    }

    override suspend fun saveSelectedCurrency(code: String) {
        settings.setSelectedCurrency(SelectedCurrency(code))
    }

    override suspend fun calculateRates(amount: Float): List<DisplayCurrency> {
        val hashMap = hashMapOf<CurrencyPair, Rate>()
        val rates = exchangeRateRepository.getRates().first()
        for (rate in rates) {
            hashMap[CurrencyPair(rate.from, rate.to)] = rate
        }

        return currencyRepository.getAllCurrencies().map {
            DisplayCurrency(it.code, it.name, 1.0f)
        }
    }
}