package io.malykh.anton.data

interface TextRequestsCoroutines {
    fun getText(): Request<String>
    fun clearSavedText(): Request<Boolean>
}