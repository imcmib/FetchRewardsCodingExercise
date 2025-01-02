package com.aivanchenko.fetch.data.di

import com.aivanchenko.fetch.data.provider.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface CommonModule {

    @Provides
    @Singleton
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProvider.Default
}
