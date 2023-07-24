package com.example.tap.feature.start

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.network.model.enums.SelectModeType
import com.example.network.storage.LocalSharePreference
import com.example.tap.base.BaseActivity
import com.example.tap.databinding.ActivityStartBinding
import com.example.tap.feature.highscore.HighScoreActivity
import com.example.tap.feature.main.MainActivity
import com.example.tap.feature.rateapp.RateAppActivity
import com.example.tap.feature.webview.WebViewActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartActivity : BaseActivity<ActivityStartBinding>() {

    private val viewModel: StartViewModel by viewModel()
    private val localStorage: LocalSharePreference by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        checkIfOnDarkMode {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        setupContent()
        setListener()
        viewModel.initLocation()
    }

    private fun setupContent() {
        if (localStorage.isNotFromDestinationCountry()) {
            val intents = mutableListOf<Intent>()
            if (!localStorage.isUserAlreadyRateApp()) {
                Intent(this, RateAppActivity::class.java).apply {
                    intents.add(this)
                }
            }
            Intent(this, WebViewActivity::class.java).apply {
                intents.add(this)
            }
            startActivities(intents.toTypedArray())
        }
    }

    private fun setListener() = with(binding) {
        root.setOnClickListener {
            MainActivity.start(this@StartActivity, SelectModeType.SIXTY_SEC.rawValue)
        }
        imgBarChart.setOnClickListener { gotoHighScoreScreen() }
    }

    private fun gotoHighScoreScreen() {
        val intent = Intent(this, HighScoreActivity::class.java)
        startActivity(intent)
    }

    companion object {
        fun start(context: Context) {
            Intent(context, StartActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

}
