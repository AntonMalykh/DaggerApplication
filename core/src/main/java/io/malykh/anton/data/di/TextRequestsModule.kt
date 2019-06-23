package io.malykh.anton.data.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Core
import io.malykh.anton.data.TextRequests

@Module
class TextRequestsModule {

    @Provides
    fun provideTextRequests(core: Core): TextRequests = core.requests
}