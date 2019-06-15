package io.malykh.anton.data

interface Response<T> {
    fun getData(): T
}
