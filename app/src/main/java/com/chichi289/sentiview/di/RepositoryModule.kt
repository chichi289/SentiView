package com.chichi289.sentiview.di

import com.chichi289.sentiview.data.repository.Repository
import com.chichi289.sentiview.domain.use_cases.UseCases
import com.chichi289.sentiview.domain.use_cases.get_all_todos.GetAllToDosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases = UseCases(
        getAllToDosUseCase = GetAllToDosUseCase(repository)
    )

}