package io.malykh.anton.data.coroutines

interface TextRequestsCoroutines {
    fun getText(): RequestCoroutines<String>
    fun clearSavedText(): RequestCoroutines<Boolean>
}