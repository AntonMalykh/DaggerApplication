package io.malykh.anton.daggerapplication

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.malykh.anton.daggerapplication.di.DaggerAppComponent
import io.malykh.anton.data.Data
import javax.inject.Inject

class DaggerApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}