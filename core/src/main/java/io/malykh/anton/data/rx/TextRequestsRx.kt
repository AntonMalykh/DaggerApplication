package io.malykh.anton.data.rx

import io.reactivex.Single

interface TextRequestsRx {
    fun getText(): RequestRx<String>
    fun clearSavedText(): RequestRx<Boolean>
}