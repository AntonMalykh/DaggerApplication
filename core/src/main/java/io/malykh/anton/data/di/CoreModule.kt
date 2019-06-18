package io.malykh.anton.data.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Core
import io.malykh.anton.data.TextRequests
import io.malykh.anton.data.TextRequestsImpl
import io.malykh.anton.data.TextStorage
import javax.inject.Singleton

@Module
internal class CoreModule {

    @Provides
    @Singleton
    fun provideTextStorage(core: Core): TextStorage = core.textStorage

    @Provides
    @Singleton
    fun provideRequestFactory(textStorage: TextStorage): TextRequests {
        return TextRequestsImpl(textStorage)
    }
}
