package io.malykh.anton.shared

import io.malykh.anton.shared.di.DaggerSharedComponent

class Shared private constructor(){
    val dispatchers: DispatcherProvider = DispatcherProviderProd()

    companion object{
        @Volatile var shared : Shared? = null
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

    init {
        DaggerSharedComponent.factory().create()
    }
}
