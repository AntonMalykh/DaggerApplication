package io.malykh.anton.screen.screen

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import io.malykh.anton.screen.R
import io.malykh.anton.screen.screen_1.ScreenRx
import kotlinx.android.synthetic.main.screen.*
import javax.inject.Inject

class ScreenCoroutines: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen)

        val viewModel =
            ViewModelProviders
                .of(this, viewModelFactory)
                .get(ScreenViewModelCoroutines::class.java)

        button.setOnClickListener { viewModel.onButtonClicked() }
        clear.setOnClickListener { viewModel.onClearClicked() }
        goTo.setOnClickListener { startActivity(Intent(this, ScreenRx::class.java)) }

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ScreenViewModelCoroutines) {
        viewModel.getTextLiveData().observe(
            this,
            Observer { text.text = it }
        )
    }
}