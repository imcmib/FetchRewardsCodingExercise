package com.aivanchenko.fetch.core.di

import com.aivanchenko.fetch.data.provider.DispatchersProvider
import dagger.hilt.components.SingletonComponent

@dagger.hilt.InstallIn(SingletonComponent::class)
@dagger.Module
object CommonModule {

    @dagger.Provides
    @javax.inject.Singleton
    fun provideDispatchersProvider(): DispatchersProvider =
        DispatchersProvider.Companion.Default
}
