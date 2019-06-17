package io.malykh.anton.shared

import kotlinx.coroutines.Dispatchers

class DispatcherProviderProd : DispatcherProvider {
    override fun Main() = Dispatchers.Main
    override fun Computation() = Dispatchers.Default
    override fun IO() = Dispatchers.IO
}