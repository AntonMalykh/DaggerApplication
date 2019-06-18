package io.malykh.anton.daggerapplication.di

import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.malykh.anton.daggerapplication.DaggerApp
import io.malykh.anton.screen.di.ScreenModule
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelBindingModule::class,
        ScreenModule::class
    ]
)
interface AppComponent: AndroidInjector<DaggerApp>{

    fun viewModels(): Map<Class<out ViewModel>, Provider<ViewModel>>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: DaggerApp): AppComponent
    }
}