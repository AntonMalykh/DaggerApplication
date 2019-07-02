package io.malykh.anton.daggerapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.malykh.anton.screen.screen.ScreenViewModelCoroutines
import io.malykh.anton.screen.ViewModelFactory
import io.malykh.anton.screen.di.ViewModelKey
import io.malykh.anton.screen.screen_1.ScreenRx
import io.malykh.anton.screen.screen_1.ScreenViewModelRx

@Module
abstract class ViewModelBindingModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ScreenViewModelCoroutines::class)
    abstract fun bindScreenViewModelCoroutines(screenViewModel: ScreenViewModelCoroutines): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScreenViewModelRx::class)
    abstract fun bindScreenViewModelRx(screenViewModel: ScreenViewModelRx): ViewModel
}