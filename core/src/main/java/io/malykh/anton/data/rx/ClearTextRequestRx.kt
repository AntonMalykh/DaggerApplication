package io.malykh.anton.data.rx

import io.malykh.anton.data.Response
import io.malykh.anton.data.ResponseImpl
import io.malykh.anton.data.TextStorage
import io.malykh.anton.shared.DispatcherProviderRx
import io.reactivex.Single
import javax.inject.Inject

internal class ClearTextRequestRx @Inject constructor(
    private val textStorage: TextStorage,
    private val dispatchers: DispatcherProviderRx
) : RequestRx<Boolean> {

    override fun execute(): Single<Response<Boolean>> {
        return Single.create<Response<Boolean>> {
            it.onSuccess(ResponseImpl(textStorage.clear()))
        }
            .subscribeOn(dispatchers.Computation())
    }

}
