package com.codylab.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.codylab.datastore.DataStoreSettings
import com.codylab.repository.datasource.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DataStoreModule {

    @Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                appContext.preferencesDataStoreFile(PREFERENCES_STORE_NAME)
            }
        )

    @Provides
    @Singleton
    fun provideSettings(
        dataStore: DataStore<Preferences>
    ): SettingsRepository = DataStoreSettings(dataStore)

    companion object {
        const val PREFERENCES_STORE_NAME = "CURRENCY"
    }
}