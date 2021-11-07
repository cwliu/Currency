package com.codylab.repository.datasource

interface SettingsRepository {
    suspend fun setLastUpdatedTime(timestamp: Long)
    suspend fun getLastUpdatedTime(): Long
}