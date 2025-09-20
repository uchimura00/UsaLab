package com.example.usalab.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "memo")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val time: String,
    val text: String,
    val photoUri: String
)