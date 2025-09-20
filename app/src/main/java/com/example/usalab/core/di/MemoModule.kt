package com.example.usalab.core.di

import com.example.usalab.data.repository.MemoRepositoryImpl
import com.example.usalab.data.useCase.MemoUseCaseImpl
import com.example.usalab.domain.repository.MemoRepository
import com.example.usalab.domain.useCase.MemoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MemoModule {

    @Binds
    @Singleton
    abstract fun bindMemoRepository(
        memoRepositoryImpl: MemoRepositoryImpl
    ): MemoRepository

    @Binds
    @Singleton
    abstract fun bindMemoUseCase(
        memoUseCaseImpl: MemoUseCaseImpl
    ): MemoUseCase
}