package io.malykh.anton.data

import io.malykh.anton.data.di.DaggerDataComponent
import java.util.*
import javax.inject.Inject

class Data private constructor(internal val textStorage: TextStorage){

    companion object {
        @Volatile var data : Data? = null
        fun initialize(textProvider: TextStorage){
            if (data == null) {
                synchronized(Data::class){
                    if (data == null) {
                        data = Data(textProvider)
                    }
                }
            }
        }

        fun get(): Data {
            Objects.requireNonNull(data,  "initialize Data first")
            return data!!
        }
    }

    @Inject
    lateinit var requests: RequestFactory

    init {
        DaggerDataComponent
            .factory()
            .create(this)
            .inject(this)
    }
}