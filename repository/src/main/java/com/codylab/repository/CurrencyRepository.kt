package com.codylab.repository

import com.codylab.domain.Currency

interface CurrencyRepository {
    fun lookupCurrency(code: String): Currency?
    fun getCurrencies(): List<Currency>
}