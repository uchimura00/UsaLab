package com.example.usalab.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.usalab.core.database.dao.MemoDao
import com.example.usalab.core.database.entity.MemoEntity

@Database(
    entities = [MemoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        const val DATABASE_NAME = "usa_lab_database"
    }
}