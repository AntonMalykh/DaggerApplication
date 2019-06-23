package io.malykh.anton.data

import io.malykh.anton.shared.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class GetTextRequest @Inject constructor(private val textStorage: TextStorage,
                                                  private val dispatchers: DispatcherProvider) : Request<String> {

    override suspend fun execute(): Response<String> {
        return withContext(dispatchers.Computation()){
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
