package io.malykh.anton.screen

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.screen.*
import javax.inject.Inject

class Screen: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen)

        val viewModel =
            ViewModelProviders
                .of(this, viewModelFactory)
                .get(ScreenViewModel::class.java)

        button.setOnClickListener { viewModel.onButtonClicked() }

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ScreenViewModel) {
        viewModel.getTextLiveData().observe(
            this,
            Observer { text.text = it }
        )
    }
}