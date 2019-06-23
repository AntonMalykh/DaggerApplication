package io.malykh.anton.data.di

import dagger.BindsInstance
import dagger.Component
import io.malykh.anton.data.Core
import io.malykh.anton.shared.di.SharedDispatchersModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class,
        SharedDispatchersModule::class
    ]
)
internal interface CoreComponent {

    fun inject(data: Core)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance data: Core) : CoreComponent
    }
}