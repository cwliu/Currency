package com.codylab.room

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(primaryKeys = ["from", "to", "value"], tableName = "Rate")
internal data class Rate(
    @ColumnInfo(name = "from") val from: String,
    @ColumnInfo(name = "to") val to: String,
    @ColumnInfo(name = "value") val value: Float
)