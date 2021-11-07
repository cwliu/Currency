package com.codylab.repository

import com.codylab.repository.datasource.TimeProvider

class TimerProviderImpl : TimeProvider {
    override fun now(): Long = System.currentTimeMillis()
}