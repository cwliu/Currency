package com.codylab.repository.di

import com.codylab.repository.CurrencyRepository
import com.codylab.repository.CurrencyRepositoryImpl
import com.codylab.repository.ExchangeRateRepository
import com.codylab.repository.ExchangeRateRepositoryImpl
import com.codylab.repository.datasource.RateDataSource
import com.codylab.repository.datasource.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    fun provideExchangeRateRepository(
        @Named("CurrencyLayer") apiRateDataSource: RateDataSource,
        settings: Settings
    ): ExchangeRateRepository {
        return ExchangeRateRepositoryImpl(
            apiRateDataSource,
            settings
        )
    }
}