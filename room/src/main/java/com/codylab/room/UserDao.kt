package com.codylab.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface RateDao {
    @Query("SELECT * FROM rate")
    fun getAll(): Flow<List<Rate>>

    @Insert
    fun insertAll(vararg rate: Rate)

    @Query("DELETE FROM rate")
    fun deleteAll()
}