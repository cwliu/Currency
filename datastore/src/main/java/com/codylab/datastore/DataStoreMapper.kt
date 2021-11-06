package com.codylab.datastore

import com.codylab.domain.SelectedCurrency

internal interface DataStoreMapper {
    fun mapToDataStoreCurrency(currency: SelectedCurrency): DataStoreCurrencyCode
    fun mapToSelectedCurrency(code: String?): SelectedCurrency?
}