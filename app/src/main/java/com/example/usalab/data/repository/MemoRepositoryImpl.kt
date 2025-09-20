package com.example.usalab.data.repository

import com.example.usalab.core.database.dao.MemoDao
import com.example.usalab.core.database.entity.MemoEntity
import com.example.usalab.domain.repository.MemoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoRepositoryImpl @Inject constructor(
    private val dao: MemoDao
) : MemoRepository {

    override fun getAllItemsStream() = dao.getAllMemos()

    override fun getItemStream(id: Int) = dao.getMemo(id)

    override suspend fun insertItem(memo: MemoEntity) = dao.insert(memo)

    override suspend fun deleteItem(memo: MemoEntity) = dao.delete(memo)

    override suspend fun updateItem(memo: MemoEntity) = dao.update(memo)
}