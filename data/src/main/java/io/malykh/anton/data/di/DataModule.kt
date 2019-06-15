package io.malykh.anton.data.di

import dagger.Module
import dagger.Provides
import io.malykh.anton.data.Data
import io.malykh.anton.data.RequestFactory
import io.malykh.anton.data.RequestFactoryImpl
import io.malykh.anton.data.TextStorage
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideTextStorage(data: Data): TextStorage = data.textStorage

    @Provides
    @Singleton
    fun provideRequestFactory(textStorage: TextStorage): RequestFactory {
        return RequestFactoryImpl(textStorage)
    }
}
