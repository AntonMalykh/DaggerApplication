package io.malykh.anton.screen.di

import dagger.Module

@Module(
    includes = [
        ScreenViewModelCoroutinesModule::class
    ]
)
class ScreenCoroutinesModule
