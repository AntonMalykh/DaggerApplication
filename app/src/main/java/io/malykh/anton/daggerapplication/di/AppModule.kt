package io.malykh.anton.daggerapplication.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import io.malykh.anton.daggerapplication.DaggerApp
import io.malykh.anton.daggerapplication.PreferencesTextStorage
import io.malykh.anton.data.Data
import javax.inject.Named
import javax.inject.Singleton

@Module
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
    fun provideData(preferences: SharedPreferences): Data {
        Data.initialize(PreferencesTextStorage(preferences))
        return Data.get()
    }
}
