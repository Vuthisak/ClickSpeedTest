package com.example.tap.feature.root

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.network.storage.LocalSharePreference
import com.example.tap.base.BaseActivity
import com.example.tap.databinding.ActivityRootBinding
import com.example.tap.feature.rateapp.RateAppActivity
import com.example.tap.feature.start.StartActivity
import com.example.tap.feature.webview.WebViewActivity
import com.example.tap.util.LiveDataObserver
import com.example.tap.util.startObserveForever
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RootActivity : BaseActivity<ActivityRootBinding>() {

    private val localStorage: LocalSharePreference by inject()
    private val viewModel by viewModel<RootViewModel>()

    private lateinit var state: LiveDataObserver<RootState>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRootBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        registerObserver()
        setupContent()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.state.removeObserver(state)
    }

    private fun registerObserver() {
        state = viewModel.state.startObserveForever {
            when (it) {
                is RootState.Loading -> showLoading()
                is RootState.Finished -> hideLoading()
                is RootState.Error -> {
                    finish()
                    startActivities(getIntentsOtherCountry().toTypedArray())
                }

                is RootState.GetLocationSuccess -> setupContent()
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun setupContent() {
        localStorage.getCountryName()?.let {
            val intents = mutableListOf<Intent>()
            if (localStorage.isNotFromDestinationCountry()) {
                intents.addAll(getIntentsOtherCountry())
            } else {
                Intent(this, StartActivity::class.java).apply {
                    intents.add(this)
                }
            }
            finish()
            startActivities(intents.toTypedArray())
        } ?: viewModel.initLocation()
    }

    private fun getIntentsOtherCountry(): MutableList<Intent> {
        val intents = mutableListOf<Intent>()
        if (!localStorage.isUserAlreadyRateApp()) {
            Intent(this, RateAppActivity::class.java).apply {
                intents.add(this)
            }
        }
        Intent(this, WebViewActivity::class.java).apply {
            intents.add(this)
        }
        return intents
    }

}