package com.codylab.datastore

import com.codylab.domain.SelectedCurrency

internal class DataStoreMapperImpl : DataStoreMapper {
    override fun mapToDataStoreCurrency(currency: SelectedCurrency) =
        DataStoreCurrencyCode(currency.code)

    override fun mapToSelectedCurrency(code: String?) = code?.let {
        SelectedCurrency(code)
    }
}