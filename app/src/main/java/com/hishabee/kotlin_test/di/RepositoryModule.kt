package com.hishabee.kotlin_test.di

import com.hishabee.kotlin_test.repo.todo.ITodoRepository
import com.hishabee.kotlin_test.repo.todo.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun provideContentRepository(repository: TodoRepository): ITodoRepository
}