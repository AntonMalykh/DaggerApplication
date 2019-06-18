package io.malykh.anton.data

class ClearTextRequest(private val textStorage: TextStorage) : Request<Boolean> {
    override suspend fun execute(): Response<Boolean> {
        return ResponseImpl(textStorage.clear())
    }
}
