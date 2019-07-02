package io.malykh.anton.shared

interface DispatcherProviderRx {
    fun Main(): Scheduler
    fun Computation(): Scheduler
    fun IO(): Scheduler
}
