package com.codylab.currency.converter.usecase

import com.codylab.domain.*
import com.codylab.repository.CurrencyRepository
import com.codylab.repository.RateRepository
import junit.framework.TestCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class ConversionUseCaseImplTest : TestCase() {

    @Mock
    lateinit var currencyRepository: CurrencyRepository

    @Mock
    lateinit var rateRepository: RateRepository

    @Test
    fun cuurencyConversion() = runBlocking {
        // Arrange
        val usd = USD_CURRENCY
        val jpy = JPY_CURRENCY
        val twd = TWD_CURRENCY
        val usdToJpy = Rate(USD_CURRENCY, jpy, 113f)
        val usdToTwd = Rate(USD_CURRENCY, twd, 27.84f)
        whenever(currencyRepository.getCurrencies()).thenReturn(listOf(usd, jpy, twd))
        whenever(rateRepository.getRates()).thenReturn(
            flowOf(
                listOf(
                    usdToJpy, usdToTwd
                )
            )
        )

        val conversionUseCase = ConversionUseCaseImpl(currencyRepository, rateRepository)
        // Act
        val conversionList = conversionUseCase.calculateRates(twd, 1000f)

        // Assert
        Assert.assertEquals(3, conversionList.size)
        Assert.assertTrue(
            Conversion(4058.908f, Rate(twd, jpy, 4.058908f)) in conversionList
        )
        Assert.assertTrue(
            Conversion(35.91954f, Rate(twd, usd, 0.03591954f)) in conversionList
        )
        Assert.assertTrue(
            Conversion(1000f, Rate(twd, twd, 1f)) in conversionList
        )
    }
}