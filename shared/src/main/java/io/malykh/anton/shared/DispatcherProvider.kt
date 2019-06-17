package io.malykh.anton.shared

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun Main(): CoroutineDispatcher
    fun Computation(): CoroutineDispatcher
    fun IO(): CoroutineDispatcher
}