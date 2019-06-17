package io.malykh.anton.daggerapplication

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.malykh.anton.daggerapplication.di.AppComponent
import io.malykh.anton.daggerapplication.di.DaggerAppComponent

class DaggerApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: AppComponent = DaggerAppComponent.factory().create(this)
        return component
    }
}