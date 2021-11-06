package com.codylab.repository.datasource

import com.codylab.domain.SelectedCurrency

interface Settings {
    suspend fun setLastUpdatedTime(timestamp: Long)
    suspend fun getLastUpdatedTime(): Long

    suspend fun setSelectedCurrency(currency: SelectedCurrency)
    suspend fun getSelectedCurrency(): SelectedCurrency?
}