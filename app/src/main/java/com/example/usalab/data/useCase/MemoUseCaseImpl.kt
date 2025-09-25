package com.example.usalab.data.useCase

import com.example.usalab.domain.repository.MemoRepository
import com.example.usalab.domain.useCase.MemoUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoUseCaseImpl @Inject constructor(
    private val memoRepository: MemoRepository
): MemoUseCase {
    override fun getAllItemsStream() = memoRepository.getAllItemsStream()

    override fun getItemStream(id: Int) = memoRepository.getItemStream(id)

    override suspend fun insertItem(memo: com.example.usalab.core.database.entity.MemoEntity) =
        memoRepository.insertItem(memo)

    override suspend fun deleteItem(memo: com.example.usalab.core.database.entity.MemoEntity) =
        memoRepository.deleteItem(memo)

    override suspend fun updateItem(memo: com.example.usalab.core.database.entity.MemoEntity) =
        memoRepository.updateItem(memo)
}