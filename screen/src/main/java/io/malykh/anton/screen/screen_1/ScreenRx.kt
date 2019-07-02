package io.malykh.anton.screen.screen_1

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import io.malykh.anton.screen.R
import javax.inject.Inject

class ScreenRx: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen)

        val viewModel =
            ViewModelProviders
                .of(this, viewModelFactory)
                .get(ScreenViewModelRx::class.java)


        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ScreenViewModelRx) {
//        viewModel.getTextLiveData().observe(
//            this,
//            Observer { text.text = it }
//        )
    }
}