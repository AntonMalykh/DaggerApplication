package io.malykh.anton.data

internal class RequestFactoryImpl(private val textStorage: TextStorage) : RequestFactory {
    override fun getTextRequest(): Request<String> {
        return GetTextRequest(textStorage)
    }
}