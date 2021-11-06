package com.codylab.network.currencylayer

import com.codylab.domain.Rate

internal interface LiveRatesResponseMapper {
    fun mapToRates(response: LiveRatesResponse): List<Rate>
}