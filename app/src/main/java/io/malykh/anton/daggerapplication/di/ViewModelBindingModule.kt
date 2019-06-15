package io.malykh.anton.daggerapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.malykh.anton.screen.ScreenViewModel
import io.malykh.anton.screen.ViewModelFactory
import io.malykh.anton.screen.di.ViewModelKey

@Module
interface ViewModelBindingModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ScreenViewModel::class)
    fun bindScreenViewModel(screenViewModel: ScreenViewModel): ViewModel
}