package io.malykh.anton.shared.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.shared.DispatcherProvider
import io.malykh.anton.shared.Shared

@Module
class SharedDispatchersModule {
    @Provides
    fun provideDispatchers(shared: Shared): DispatcherProvider = shared.dispatchers
}