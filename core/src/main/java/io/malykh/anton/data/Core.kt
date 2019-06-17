package io.malykh.anton.data

import io.malykh.anton.data.di.DaggerCoreComponent
import java.util.*
import javax.inject.Inject

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
            Objects.requireNonNull(data,  "initialize Core first")
            return data!!
        }
    }

    @Inject
    lateinit var requests: RequestFactory

    init {
        DaggerCoreComponent
            .factory()
            .create(this)
            .inject(this)
    }
}