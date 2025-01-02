package com.aivanchenko.fetch.core.di

import com.aivanchenko.fetch.data.repository.ItemsRepositoryImpl
import com.aivanchenko.fetch.domain.repository.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @javax.inject.Singleton
    fun bindItemsRepository(impl: ItemsRepositoryImpl): ItemsRepository
}
