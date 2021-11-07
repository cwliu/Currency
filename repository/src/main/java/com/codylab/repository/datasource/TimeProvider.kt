package com.codylab.repository.datasource

interface TimeProvider {
    fun now(): Long
}