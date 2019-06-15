package io.malykh.anton.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GetTextRequest(private val textStorage: TextStorage) : Request<String> {
    override suspend fun execute(): Response<String> {
        return withContext(Dispatchers.Default){
            var result = textStorage.restore()
            if (result != null) {
                return@withContext ResponseImpl(result)
            }

            result = "Hello Dagger"
            textStorage.store("$result from storage")
            ResponseImpl(result)
        }
    }
}
