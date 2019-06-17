package io.malykh.anton.data

interface Request<T> {
    suspend fun execute(): Response<T>
}