package io.malykh.anton.shared

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DispatcherProviderRxProd @Inject constructor(): DispatcherProviderRx{
    override fun Main(): Scheduler = AndroidSchedulers.mainThread()
    override fun Computation(): Scheduler = Schedulers.computation()
    override fun IO(): Scheduler = Schedulers.io()
}
