package io.malykh.anton.data.di

import dagger.BindsInstance
import dagger.Component
import io.malykh.anton.data.Data
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class
    ]
)
interface DataComponent {

    fun inject(data: Data)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance data: Data) : DataComponent
    }
}