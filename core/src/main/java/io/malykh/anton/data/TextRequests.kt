package io.malykh.anton.data

interface TextRequests {
    fun getText(): Request<String>
    fun clearSavedText(): Request<Boolean>
}