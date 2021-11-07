package com.codylab.repository

import com.codylab.domain.Currency
import com.codylab.domain.SUPPORTED_CURRENCIES

class CurrencyRepositoryImpl : CurrencyRepository {
    override fun lookupCurrency(code: String): Currency? {
        return SUPPORTED_CURRENCIES[code]
    }

    override fun getCurrencies(): List<Currency> {
        return SUPPORTED_CURRENCIES.values.toList().sortedWith(compareBy { it.code })
    }
}