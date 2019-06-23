package io.malykh.anton.shared.di

import dagger.Component
import io.malykh.anton.shared.Shared
import javax.inject.Singleton

@Singleton
@Component
internal interface SharedComponent {

    fun inject(shared: Shared)

    @Component.Factory
    interface Factory {
        fun create(): SharedComponent
    }
}