package io.malykh.anton.data

class ResponseImpl<T>(private val result: T) : Response<T> {
    override fun getData(): T = result
}