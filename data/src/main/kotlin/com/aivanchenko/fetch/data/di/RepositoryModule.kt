package com.aivanchenko.fetch.data.di

import com.aivanchenko.fetch.data.repository.ItemsRepositoryImpl
import com.aivanchenko.fetch.domain.repository.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindItemsRepository(impl: ItemsRepositoryImpl): ItemsRepository
}
