package io.malykh.anton.screen.screen_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.malykh.anton.data.rx.TextRequestsRx
import io.malykh.anton.shared.DispatcherProviderRx
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ScreenViewModelRx @Inject constructor(
    private val textRequests: TextRequestsRx,
    private val dispatchersRx: DispatcherProviderRx
) : ViewModel() {

    var clearJobs: CompositeDisposable? = null
    var textJob: Disposable? = null

    private val textData = MutableLiveData<String>()

    fun getTextLiveData(): LiveData<String> = textData

    fun onButtonClicked() {
        clearJobs.disposeSafely()
        textJob.disposeSafely()
        textJob = textRequests
            .getText()
            .execute()
            .observeOn(dispatchersRx.Main())
            .subscribe { success ->
                textData.value = success.getData()
            }
    }

    fun onClearClicked() {
        clearJobs.disposeSafely()
        textJob.disposeSafely()
        clearJobs = CompositeDisposable()
        clearJobs!!.add(
            textRequests
                .clearSavedText()
                .execute()
                .observeOn(dispatchersRx.Main())
                .doAfterSuccess {
                    clearJobs!!.add(
                        Observable.timer(500, TimeUnit.MILLISECONDS)
                            .observeOn(dispatchersRx.Main())
                            .subscribe {
                                textData.value = ""
                        }
                    )
                }
                .subscribe { success ->
                    val isCleared = success.getData()
                    textData.value = when {
                        isCleared -> "Cleared"
                        else -> "Nothing to be cleared"
                    }
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        clearJobs.disposeSafely()
        textJob.disposeSafely()
    }

    private fun Disposable?.disposeSafely(){
        this?.let {
            if (!it.isDisposed)
                it.dispose()
        }
    }
}