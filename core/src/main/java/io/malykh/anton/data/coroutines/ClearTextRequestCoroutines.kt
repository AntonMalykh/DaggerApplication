package io.malykh.anton.data.coroutines

import io.malykh.anton.data.Response
import io.malykh.anton.data.ResponseImpl
import io.malykh.anton.data.TextStorage
import io.malykh.anton.shared.DispatcherProviderCoroutines
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class ClearTextRequestCoroutines @Inject constructor(
    private val textStorage: TextStorage,
    private val dispatchers: DispatcherProviderCoroutines
) : RequestCoroutines<Boolean> {

    override suspend fun execute(): Response<Boolean> {
        return withContext(dispatchers.Computation()){
            ResponseImpl(textStorage.clear())
        }
    }
}
