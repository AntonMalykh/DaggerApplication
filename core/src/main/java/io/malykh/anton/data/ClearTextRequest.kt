package io.malykh.anton.data

import io.malykh.anton.shared.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class ClearTextRequest @Inject constructor(private val textStorage: TextStorage,
                                                    private val dispatchers: DispatcherProvider) : Request<Boolean> {

    override suspend fun execute(): Response<Boolean> {
        return withContext(dispatchers.Computation()){
            ResponseImpl(textStorage.clear())
        }
    }
}
