package io.malykh.anton.data.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Core
import io.malykh.anton.data.TextRequestsCoroutines

@Module
class TextRequestsModule {

    @Provides
    fun provideTextRequestsCoroutines(core: Core): TextRequestsCoroutines = core.requestsCoroutines

    @Provides
    fun provideTextRequestsRx(core: Core): TextRequestsRx = core.requestsRx
}