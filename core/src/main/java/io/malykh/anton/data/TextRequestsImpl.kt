package io.malykh.anton.data

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
internal class TextRequestsImpl @Inject constructor() : TextRequests {

    @Inject
    lateinit var getTextRequestProvider: Provider<GetTextRequest>
    @Inject
    lateinit var getClearTextRequestProvider: Provider<ClearTextRequest>

    override fun getText(): Request<String> {
        return getTextRequestProvider.get()
    }

    override fun clearSavedText(): Request<Boolean> {
        return getClearTextRequestProvider.get()
    }
}