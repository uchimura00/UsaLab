package com.example.usalab.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.usalab.core.database.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Query("SELECT * from memo ORDER BY title ASC")
    fun getAllMemos(): Flow<List<MemoEntity>>

    @Query("SELECT * from memo WHERE id = :id")
    fun getMemo(id: Int): Flow<MemoEntity?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(memo: MemoEntity)

    @Update
    suspend fun update(memo: MemoEntity)

    @Delete
    suspend fun delete(memo: MemoEntity)
}