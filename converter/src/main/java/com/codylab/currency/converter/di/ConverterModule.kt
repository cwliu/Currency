package com.codylab.currency.converter.di

import com.codylab.currency.converter.usecase.ConversionUseCase
import com.codylab.currency.converter.usecase.ConversionUseCaseImpl
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.RateRepository
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
        rateRepository: RateRepository,
        currencyRepository: CurrencyRepository
    ): ConversionUseCase {
        return ConversionUseCaseImpl(
            currencyRepository,
            rateRepository
        )
    }
}
