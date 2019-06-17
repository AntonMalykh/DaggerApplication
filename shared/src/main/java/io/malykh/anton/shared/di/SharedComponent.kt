package io.malykh.anton.shared.di

import dagger.Component

@Component(
    modules = [
        SharedModule::class
    ]
)
interface SharedComponent {
    @Component.Factory
    interface Factory {
        fun create(): SharedComponent
    }
}