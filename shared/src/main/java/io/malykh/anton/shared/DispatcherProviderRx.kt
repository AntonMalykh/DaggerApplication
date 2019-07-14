package io.malykh.anton.shared

import io.reactivex.Scheduler

interface DispatcherProviderRx {
    fun Main(): Scheduler
    fun Computation(): Scheduler
    fun IO(): Scheduler
}
