package io.malykh.anton.data

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
internal class TextRequestsCoroutinesImpl
@Inject constructor(private val getTextRequestProvider: Provider<GetTextRequest>,
                    private val getClearTextRequestProvider: Provider<ClearTextRequest>)
    : TextRequestsCoroutines {

    override fun getText(): Request<String> {
        return getTextRequestProvider.get()
    }

    override fun clearSavedText(): Request<Boolean> {
        return getClearTextRequestProvider.get()
    }
}