package io.malykh.anton.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.malykh.anton.data.RequestFactory
import io.malykh.anton.shared.DispatcherProvider
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ScreenViewModel @Inject constructor(var requestFactory: RequestFactory,
                                          dispatchers: DispatcherProvider)
    : ViewModel(), CoroutineScope{

    override val coroutineContext: CoroutineContext = dispatchers.Main() + Job()

    private val textData = MutableLiveData<String>()

    fun onButtonClicked() {
        launch {
            textData.value = requestFactory.getTextRequest().execute().getData()
        }
    }

    fun getTextLiveData(): LiveData<String> = textData

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}