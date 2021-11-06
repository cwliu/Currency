package com.codylab.network.currencylayer

import java.sql.Timestamp

/*
Example:
{
    "success": true,
    "terms": "https://currencylayer.com/terms",
    "privacy": "https://currencylayer.com/privacy",
    "timestamp": 1432400348,
    "source": "USD",
    "quotes": {
        "USDAUD": 1.278342,
        "USDEUR": 1.278342,
        "USDGBP": 0.908019,
        "USDPLN": 3.731504
    }
}
 */
internal data class LiveRatesResponse(
    val success: Boolean?,
    val terms: String?,
    val privacy: String?,
    val timestamp: Long?,
    val source: String?,
    val quotes: Map<String, Float>?
)

