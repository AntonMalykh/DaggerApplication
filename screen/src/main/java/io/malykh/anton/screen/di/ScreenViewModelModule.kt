package io.malykh.anton.screen.di

import dagger.Module
import io.malykh.anton.data.di.TextRequestsModule
import io.malykh.anton.shared.di.SharedModule

@Module(
    includes = [
        TextRequestsModule::class,
        SharedModule::class
    ]
)
class ScreenViewModelModule
