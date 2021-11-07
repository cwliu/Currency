package com.codylab.repository

import com.codylab.domain.Currency

interface CurrencyRepository {
    fun getCurrency(code: String): Currency?
    fun getCurrencies(): List<Currency>
}