package com.codylab.network.di

import com.codylab.network.CurrencyLayerDataSource
import com.codylab.network.currencylayer.CurrencyLayerApi
import com.codylab.network.currencylayer.LiveRatesResponseMapper
import com.codylab.network.currencylayer.CurrencyLayerRatesResponseMapperImpl
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.datasource.RateDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


@Module
@InstallIn(SingletonComponent::class)
internal class CurrencyLayerApiModule {
    @Provides
    @Singleton
    fun provideApiClient(): Retrofit {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )

        return Retrofit.Builder()
            .baseUrl(CURRENCY_LAYER_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyLayerApi(retrofit: Retrofit): CurrencyLayerApi {
        return retrofit.create(CurrencyLayerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLiveRatesResponseMapper(currencyRepository: CurrencyRepository): LiveRatesResponseMapper {
        return CurrencyLayerRatesResponseMapperImpl(currencyRepository)
    }

    @Provides
    @Singleton
    @Named("CurrencyLayer")
    fun provideCurrencyLayerDataSource(
        currencyLayerApi: CurrencyLayerApi,
        liveRatesResponseMapper: LiveRatesResponseMapper,
        @Named("IO") ioDispatcher: CoroutineDispatcher
    ): RateDataSource {
        return CurrencyLayerDataSource(currencyLayerApi, liveRatesResponseMapper, ioDispatcher)
    }

    companion object {
        const val CURRENCY_LAYER_API = "http://api.currencylayer.com/"
    }
}