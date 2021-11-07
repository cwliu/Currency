package com.codylab.repository

import com.codylab.domain.JPY_CURRENCY
import com.codylab.domain.Rate
import com.codylab.domain.USD_CURRENCY
import com.codylab.repository.RateRepositoryImpl.Companion.REFRESH_TIME_IN_MILLI_SECOND
import com.codylab.repository.datasource.ReadableRateDataSource
import com.codylab.repository.datasource.SettingsRepository
import com.codylab.repository.datasource.TimeProvider
import com.codylab.repository.datasource.WritableRateDataSource
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.inOrder
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class RateRepositoryImplTest : TestCase() {
    @Mock
    lateinit var localRateReader: ReadableRateDataSource

    @Mock
    lateinit var localRateWriter: WritableRateDataSource

    @Mock
    lateinit var apiRateReader: ReadableRateDataSource

    @Mock
    lateinit var settingsRepository: SettingsRepository

    @Mock
    lateinit var timeProvider: TimeProvider

    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun testShouldNotRefresh() = runBlockingTest {
        // Arrange
        val rateRepository = RateRepositoryImpl(
            localRateReader,
            localRateWriter,
            apiRateReader,
            settingsRepository,
            timeProvider,
            testDispatcher
        )
        val lastUpdatedTime = 1636291318632L
        val withInRefreshTime = (lastUpdatedTime + REFRESH_TIME_IN_MILLI_SECOND - 1)
        whenever(timeProvider.now()).thenReturn(withInRefreshTime)
        whenever(settingsRepository.getLastUpdatedTime()).thenReturn(lastUpdatedTime)

        // Act
        rateRepository.refreshRateIfNeed()

        // Assert
        verify(apiRateReader, never()).getRates()
    }

    @Test
    fun testShouldRefresh() = runBlockingTest {
        // Arrange
        val rateRepository = RateRepositoryImpl(
            localRateReader,
            localRateWriter,
            apiRateReader,
            settingsRepository,
            timeProvider,
            testDispatcher
        )
        val lastUpdatedTime = 0L
        val withInRefreshTime = (lastUpdatedTime + REFRESH_TIME_IN_MILLI_SECOND + 1)
        whenever(timeProvider.now()).thenReturn(withInRefreshTime)
        whenever(settingsRepository.getLastUpdatedTime()).thenReturn(lastUpdatedTime)
        val rates = listOf(Rate(USD_CURRENCY, JPY_CURRENCY, 1.0f))
        whenever(apiRateReader.getRates()).thenReturn(flowOf(rates))

        // Act
        rateRepository.refreshRateIfNeed()

        // Assert
        val inOrder = inOrder(localRateWriter, apiRateReader, settingsRepository)
        inOrder.verify(apiRateReader).getRates()
        inOrder.verify(localRateWriter).delete()
        inOrder.verify(localRateWriter).addRates(rates)
        inOrder.verify(settingsRepository).setLastUpdatedTime(withInRefreshTime)
    }
}