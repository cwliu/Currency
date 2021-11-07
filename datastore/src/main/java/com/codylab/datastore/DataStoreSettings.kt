package com.codylab.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.codylab.domain.SelectedCurrency
import com.codylab.repository.datasource.SettingsRepository
import kotlinx.coroutines.flow.first

internal class DataStoreSettings(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {
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

    companion object {
        const val KEY_LAST_UPDATED_TIME = "KEY_LAST_UPDATED_TIME"
    }
}