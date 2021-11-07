package com.codylab.currency.converter.mock

import com.codylab.domain.Conversion
import com.codylab.domain.Currency
import com.codylab.domain.Rate


val MOCK_SELECTED_CURRENCY = Currency("THB", "Thai Baht")

val MOCK_CURRENCY_LIST = listOf(
    Currency("USD", "United States Dollar"),
    Currency("THB", "Thai Baht"),
    Currency("TWD", "New Taiwan Dollar"),
)

val MOCK_CONVERSION_LIST = mutableListOf<Conversion>().apply {
    repeat(50) {
        add(
            Conversion(
                100.0f,
                Rate(
                    Currency("USD", "United States Dollar"),
                    Currency("THB", "Thai Baht"),
                    33.36f
                )
            )
        )
        add(
            Conversion(
                100.0f,
                Rate(
                    Currency("USD", "United States Dollar"),
                    Currency("TWD", "New Taiwan Dollar"),
                    27.84f
                )
            )
        )
    }
}