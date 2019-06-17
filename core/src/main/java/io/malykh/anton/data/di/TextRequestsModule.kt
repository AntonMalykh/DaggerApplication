package io.malykh.anton.data.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Core
import javax.inject.Singleton

@Module
class TextRequestsModule {

    @Provides
    fun provideTextRequests(data: Core) = data.requests
}