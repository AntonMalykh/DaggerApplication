package io.malykh.anton.data.rx

import io.malykh.anton.data.Response
import io.reactivex.Single

interface RequestRx<T> {
    fun execute(): Single<Response<T>>
}
