package io.malykh.anton.screen.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.malykh.anton.data.coroutines.TextRequestsCoroutines
import io.malykh.anton.shared.DispatcherProviderCoroutines
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ScreenViewModelCoroutines
@Inject constructor(private val textRequests: TextRequestsCoroutines,
                    private val dispatchers: DispatcherProviderCoroutines)
    : ViewModel(), CoroutineScope{

    override val coroutineContext: CoroutineContext = dispatchers.Main() + Job()

    private val textData = MutableLiveData<String>()

    private var clearJob: Job? = null

    fun getTextLiveData(): LiveData<String> = textData

    fun onButtonClicked() {
        clearJob?.cancel()
        launch {
            textData.value = withContext(dispatchers.Computation()){textRequests.getText().execute().getData()}
        }
    }

    fun onClearClicked() {
        clearJob?.cancel()
        clearJob = launch {
            val isCleared = withContext(dispatchers.Computation()){textRequests.clearSavedText().execute().getData()}
            textData.value = when {
                isCleared -> "Cleared"
                else -> "Nothing to be cleared"
            }

            delay(500)
            textData.value = ""
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}