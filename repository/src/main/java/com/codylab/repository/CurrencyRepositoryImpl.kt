package com.codylab.repository

import com.codylab.domain.Currency
import com.codylab.domain.SUPPORTED_CURRENCIES

class CurrencyRepositoryImpl : CurrencyRepository {
    override fun getCurrency(code: String): Currency? {
        return SUPPORTED_CURRENCIES[code]
    }

    override fun getAllCurrencies(): List<Currency> {
        return SUPPORTED_CURRENCIES.values.toList()
    }
}