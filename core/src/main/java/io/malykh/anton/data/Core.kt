package io.malykh.anton.data

import io.malykh.anton.data.di.DaggerCoreComponent
import javax.inject.Inject
import javax.inject.Singleton

class Core private constructor(internal val textStorage: TextStorage){

    companion object {
        @Volatile var data : Core? = null
        fun initialize(textProvider: TextStorage){
            if (data == null) {
                synchronized(Core::class){
                    if (data == null) {
                        data = Core(textProvider)
                    }
                }
            }
        }

        fun get(): Core {
            checkNotNull(data){
                "initialize Core first"
            }
            return data!!
        }
    }

    @Inject
    @Singleton
    internal lateinit var requests: TextRequestsImpl

    init {
        DaggerCoreComponent
            .factory()
            .create(this)
            .inject(this)
    }
}