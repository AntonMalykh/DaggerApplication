package io.malykh.anton.data

interface TextStorage {
    fun store(text: String)
    fun restore(): String?
}