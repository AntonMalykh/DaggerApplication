package io.malykh.anton.data

class ResponseImpl<T>(val result: T) : Response<T> {
    override fun getData(): T = result
}