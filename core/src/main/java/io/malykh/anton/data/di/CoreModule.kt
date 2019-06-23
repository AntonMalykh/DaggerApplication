package io.malykh.anton.data.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Core
import io.malykh.anton.data.TextRequests
import io.malykh.anton.data.TextRequestsImpl
import io.malykh.anton.data.TextStorage
import io.malykh.anton.shared.DispatcherProvider
import io.malykh.anton.shared.Shared
import javax.inject.Singleton

@Module
internal class CoreModule {

    @Provides
    @Singleton
    fun provideTextStorage(core: Core): TextStorage = core.textStorage

    @Provides
    @Singleton
    fun provideShared() = Shared.get()
}
