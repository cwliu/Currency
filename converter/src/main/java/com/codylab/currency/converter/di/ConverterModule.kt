package com.codylab.currency.converter.di

import com.codylab.currency.converter.usecase.ConvertUseCase
import com.codylab.currency.converter.usecase.ConversionUseCaseImpl
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.ExchangeRateRepository
import com.codylab.repository.datasource.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ConverterModule {
    @Provides
    @ViewModelScoped
    fun provideConvertUseCase(
        exchangeRateRepository: ExchangeRateRepository,
        currencyRepository: CurrencyRepository,
        settings: Settings
    ): ConvertUseCase {
        return ConversionUseCaseImpl(
            exchangeRateRepository,
            currencyRepository,
            settings
        )
    }
}