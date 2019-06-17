package io.malykh.anton.data

interface RequestFactory {
    fun getTextRequest(): Request<String>
}