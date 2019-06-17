package io.malykh.anton.screen

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import io.malykh.anton.data.RequestFactory
import io.malykh.anton.shared.DispatcherProvider
import kotlinx.android.synthetic.main.screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Screen: DaggerAppCompatActivity() {

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var requestFactory: RequestFactory

    @Inject
    lateinit var dispatcherProvider: DispatcherProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen)

//        val viewModel =
//            ViewModelProviders
//                .of(this, viewModelFactory)
//                .get(ScreenViewModel::class.java)

//        button.setOnClickListener { viewModel.onButtonClicked() }
//
//        observeViewModel(viewModel)

        button.setOnClickListener{
            GlobalScope.launch(dispatcherProvider.Main()) {
                text.text = withContext(dispatcherProvider.Computation()){
                    requestFactory.getTextRequest().execute().getData()
                }
            }
        }
    }

    private fun observeViewModel(viewModel: ScreenViewModel) {
        viewModel.getTextLiveData().observe(
            this,
            Observer { text.text = it }
        )
    }
}