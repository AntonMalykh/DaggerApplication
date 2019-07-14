package io.malykh.anton.data.rx

import io.malykh.anton.data.coroutines.ClearTextRequestCoroutines
import io.malykh.anton.data.coroutines.GetTextRequestCoroutines
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
internal class TextRequestsRxImpl @Inject constructor(
    private val getTextRequestProvider: Provider<GetTextRequestRx>,
    private val clearSavedTextRequestProvider: Provider<ClearTextRequestRx>
) : TextRequestsRx {

    override fun getText(): RequestRx<String> = getTextRequestProvider.get()

    override fun clearSavedText(): RequestRx<Boolean> = clearSavedTextRequestProvider.get()
}