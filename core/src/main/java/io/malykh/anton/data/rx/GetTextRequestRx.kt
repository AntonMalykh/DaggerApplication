package io.malykh.anton.data.rx

import io.malykh.anton.data.Response
import io.malykh.anton.data.ResponseImpl
import io.malykh.anton.data.TextStorage
import io.malykh.anton.shared.DispatcherProviderRx
import io.reactivex.Single
import javax.inject.Inject

internal class GetTextRequestRx @Inject constructor(
    private val textStorage: TextStorage,
    private val dispatchers: DispatcherProviderRx
) : RequestRx<String> {

    override fun execute(): Single<Response<String>> {
        return Single.create<Response<String>> {
            var result = textStorage.restore()
            if (result != null) {
                it.onSuccess(ResponseImpl(result))
            }

            result = "Hello Dagger"
            textStorage.store("$result from storage")
            it.onSuccess(ResponseImpl(result))
        }
            .subscribeOn(dispatchers.Computation())
    }
}
