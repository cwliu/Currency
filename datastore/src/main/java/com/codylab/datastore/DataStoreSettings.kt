package com.codylab.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.codylab.domain.SelectedCurrency
import com.codylab.repository.datasource.Settings
import kotlinx.coroutines.flow.first

internal class DataStoreSettings(
    private val dataStore: DataStore<Preferences>,
    private val dataStoreMapper: DataStoreMapper
) : Settings {
    override suspend fun setLastUpdatedTime(timestamp: Long) {
        val key = longPreferencesKey(KEY_LAST_UPDATED_TIME)
        dataStore.edit {
            it[key] = timestamp
        }
    }

    override suspend fun getLastUpdatedTime(): Long {
        val key = longPreferencesKey(KEY_LAST_UPDATED_TIME)
        return dataStore.data.first()[key] ?: 0
    }

    override suspend fun setSelectedCurrency(currency: SelectedCurrency) {
        val dataStoreCurrency = dataStoreMapper.mapToDataStoreCurrency(currency)
        val key = stringPreferencesKey(KEY_SELECTED_CURRENCY_CODE)
        dataStore.edit {
            it[key] = dataStoreCurrency.code
        }
    }

    override suspend fun getSelectedCurrency(): SelectedCurrency? {
        val key = stringPreferencesKey(KEY_SELECTED_CURRENCY_CODE)
        val code = dataStore.data.first()[key]
        return dataStoreMapper.mapToSelectedCurrency(code)
    }

    companion object {
        const val KEY_LAST_UPDATED_TIME = "KEY_LAST_UPDATED_TIME"
        const val KEY_SELECTED_CURRENCY_CODE = "KEY_SELECTED_CURRENCY_CODE"
    }
}