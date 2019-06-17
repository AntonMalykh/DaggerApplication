package io.malykh.anton.daggerapplication.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import io.malykh.anton.daggerapplication.DaggerApp
import io.malykh.anton.daggerapplication.PreferencesTextStorage
import io.malykh.anton.data.Core
import io.malykh.anton.data.di.TextRequestsModule
import io.malykh.anton.shared.Shared
import io.malykh.anton.shared.di.SharedModule
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [
        TextRequestsModule::class,
        SharedModule::class
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(daggerApp: DaggerApp) = daggerApp as Application

    @Provides
    @Named("Application_context")
    @Singleton
    fun provideApplicationContext(application: Application) = application as Context

    @Provides
    @Singleton
    fun providePreferences(@Named("Application_context") context: Context): SharedPreferences {
        return context.getSharedPreferences("PREFERENCES_NAME", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideCore(preferences: SharedPreferences): Core {
        Core.initialize(PreferencesTextStorage(preferences))
        return Core.get()
    }

    @Provides
    @Singleton
    fun provideShared() = Shared.get()
}
