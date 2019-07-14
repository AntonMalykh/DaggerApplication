package io.malykh.anton.data.coroutines

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
internal class TextRequestsCoroutinesImpl
@Inject constructor(
    private val getTextRequestProvider: Provider<GetTextRequestCoroutines>,
    private val getClearTextRequestProvider: Provider<ClearTextRequestCoroutines>
) : TextRequestsCoroutines {

    override fun getText(): RequestCoroutines<String> = getTextRequestProvider.get()

    override fun clearSavedText(): RequestCoroutines<Boolean> = getClearTextRequestProvider.get()
}