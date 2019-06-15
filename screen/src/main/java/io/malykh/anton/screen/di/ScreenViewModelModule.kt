package io.malykh.anton.screen.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Data
import io.malykh.anton.data.RequestFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class ScreenViewModelModule {
    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    @Provides
    fun provideRequestFactory(data: Data): RequestFactory {
        return data.requests
    }
}
