package com.codylab.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Rate::class], version = 1)
internal abstract class AppDateBase: RoomDatabase(){
    abstract fun rateDao(): RateDao
}