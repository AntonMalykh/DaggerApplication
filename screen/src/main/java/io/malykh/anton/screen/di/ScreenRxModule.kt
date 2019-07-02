package io.malykh.anton.screen.di

import dagger.Module

@Module(
    includes = [
        ScreenViewModelRxModule::class
    ]
)
class ScreenRxModule
