package io.malykh.anton.shared

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DispatcherProviderRxProd @Inject constructor(): DispatcherProviderRx{
    override fun Main(): Scheduler {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Computation(): Scheduler {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun IO(): Scheduler {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
