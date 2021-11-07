package com.codylab.repository.di

import com.codylab.repository.*
import com.codylab.repository.RateRepositoryImpl
import com.codylab.repository.datasource.ReadableRateDataSource
import com.codylab.repository.datasource.SettingsRepository
import com.codylab.repository.datasource.TimeProvider
import com.codylab.repository.datasource.WritableRateDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RepositoryModule {
    @Provides
    @Singleton
    fun provideCurrencyRepository(): CurrencyRepository = CurrencyRepositoryImpl()

    @Provides
    @Singleton
    fun provideTimeProvider(): TimeProvider = TimerProviderImpl()

    @Provides
    @Singleton
    fun provideExchangeRateRepository(
        @Named("CurrencyLayer") apiRateDataSource: ReadableRateDataSource,
        @Named("Room") roomRateDataReader: ReadableRateDataSource,
        @Named("Room") roomRateDataWriter: WritableRateDataSource,
        settingsRepository: SettingsRepository,
        timeProvider: TimeProvider,
        @Named("IO") ioDispatcher: CoroutineDispatcher
    ): RateRepository {
        return RateRepositoryImpl(
            roomRateDataReader,
            roomRateDataWriter,
            apiRateDataSource,
            settingsRepository,
            timeProvider,
            ioDispatcher
        )
    }
}