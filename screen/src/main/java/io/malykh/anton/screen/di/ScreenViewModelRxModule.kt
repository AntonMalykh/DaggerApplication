package io.malykh.anton.screen.di

import dagger.Module
import io.malykh.anton.data.di.TextRequestsModule
import io.malykh.anton.shared.di.SharedDispatchersModule

@Module(
    includes = [
        TextRequestsModule::class,
        SharedDispatchersModule::class
    ]
)
class ScreenViewModelRxModule
