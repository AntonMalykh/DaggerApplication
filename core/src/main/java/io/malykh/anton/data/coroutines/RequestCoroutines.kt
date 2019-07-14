package io.malykh.anton.data.coroutines

import io.malykh.anton.data.Response

interface RequestCoroutines<T> {
    suspend fun execute(): Response<T>
}