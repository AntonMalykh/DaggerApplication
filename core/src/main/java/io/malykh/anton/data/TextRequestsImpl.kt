package io.malykh.anton.data

internal class TextRequestsImpl(private val textStorage: TextStorage) : TextRequests {
    override fun getText(): Request<String> {
        return GetTextRequest(textStorage)
    }

    override fun clearSavedText(): Request<Boolean> {
        return ClearTextRequest(textStorage)
    }
}