package com.example.usalab.domain.repository

import com.example.usalab.core.database.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

interface MemoRepository {

    fun getAllItemsStream(): Flow<List<MemoEntity>>

    fun getItemStream(id: Int): Flow<MemoEntity?>

    suspend fun insertItem(memo: MemoEntity)

    suspend fun deleteItem(memo: MemoEntity)

    suspend fun updateItem(memo: MemoEntity)
}