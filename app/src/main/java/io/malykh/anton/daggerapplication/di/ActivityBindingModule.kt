package io.malykh.anton.daggerapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.malykh.anton.screen.Screen
import io.malykh.anton.screen.di.ScreenModule

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(modules = [ScreenModule::class])
    fun bindScreen(): Screen
}
