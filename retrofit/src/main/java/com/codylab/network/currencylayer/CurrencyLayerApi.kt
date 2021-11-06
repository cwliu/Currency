package com.codylab.network.currencylayer

import retrofit2.http.GET
import retrofit2.http.Query

// https://currencylayer.com/documentation
internal interface CurrencyLayerApi {
    @GET("live")
    suspend fun liveRates(@Query("access_key") accessKey: String): LiveRatesResponse
}

