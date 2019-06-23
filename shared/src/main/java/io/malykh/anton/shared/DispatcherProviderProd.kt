package io.malykh.anton.shared

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DispatcherProviderProd @Inject constructor() : DispatcherProvider {
    override fun Main() = Dispatchers.Main
    override fun Computation() = Dispatchers.Default
    override fun IO() = Dispatchers.IO
}