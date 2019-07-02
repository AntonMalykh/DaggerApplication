package io.malykh.anton.shared.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.shared.DispatcherProviderCoroutines
import io.malykh.anton.shared.DispatcherProviderRx
import io.malykh.anton.shared.Shared

@Module
class SharedDispatchersModule {
    @Provides
    fun provideDispatchersCoroutines(shared: Shared): DispatcherProviderCoroutines = shared.dispatchersCoroutines

    @Provides
    fun provideDispatchersRx(shared: Shared): DispatcherProviderRx = shared.dispatchersRx
}