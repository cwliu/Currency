package com.codylab.room.di

import android.content.Context
import androidx.room.Room
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.datasource.ReadableRateDataSource
import com.codylab.repository.datasource.WritableRateDataSource
import com.codylab.room.AppDateBase
import com.codylab.room.RoomRateDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal class RoomModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): AppDateBase {
        return Room.databaseBuilder(
            context,
            AppDateBase::class.java, "currency-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRoomRateDataSource(
        appDateBase: AppDateBase,
        currencyRepository: CurrencyRepository
    ): RoomRateDataSource {
        return RoomRateDataSource(
            appDateBase,
            currencyRepository
        )
    }

    @Provides
    @Singleton
    @Named("Room")
    fun provideReadableRateDataSource(
        roomRateDataSource: RoomRateDataSource
    ): ReadableRateDataSource = roomRateDataSource

    @Provides
    @Singleton
    @Named("Room")
    fun provideWritableRateDataSource(
        roomRateDataSource: RoomRateDataSource
    ): WritableRateDataSource = roomRateDataSource
}