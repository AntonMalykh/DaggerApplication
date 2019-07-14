package io.malykh.anton.data.coroutines

import io.malykh.anton.data.Response
import io.malykh.anton.data.ResponseImpl
import io.malykh.anton.data.TextStorage
import io.malykh.anton.shared.DispatcherProviderCoroutines
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class GetTextRequestCoroutines @Inject constructor(
    private val textStorage: TextStorage,
    private val dispatchers: DispatcherProviderCoroutines
) :
    RequestCoroutines<String> {

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
