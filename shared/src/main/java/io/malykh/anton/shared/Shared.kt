package io.malykh.anton.shared

import io.malykh.anton.shared.di.DaggerSharedComponent
import javax.inject.Inject
import javax.inject.Singleton

class Shared private constructor(){
    companion object{
        @Volatile private var shared : Shared? = null
        fun get(): Shared {
            if (shared == null) {
                synchronized(Shared::class){
                    if (shared == null) {
                        shared = Shared()
                    }
                }
            }
            return shared!!
        }
    }

    @Inject
    @Singleton
    internal lateinit var dispatchers: DispatcherProviderProd

    init {
        DaggerSharedComponent
            .factory()
            .create()
            .inject(this)
    }
}
