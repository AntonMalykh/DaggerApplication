package io.malykh.anton.daggerapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.malykh.anton.screen.screen.ScreenCoroutines
import io.malykh.anton.screen.di.ScreenCoroutinesModule
import io.malykh.anton.screen.di.ScreenRxModule
import io.malykh.anton.screen.screen_1.ScreenRx

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(modules = [ScreenCoroutinesModule::class])
    fun bindScreenCoroutines(): ScreenCoroutines

    @ContributesAndroidInjector(modules = [ScreenRxModule::class])
    fun bindScreenRx():ScreenRx
}
