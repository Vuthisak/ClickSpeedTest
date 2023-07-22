package com.example.clickspeedtest.feature.highscore

import android.os.Bundle
import com.example.clickspeedtest.R
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityHighScoreBinding
import com.example.network.storage.LocalSharePreference
import org.koin.android.ext.android.inject

class HighScoreActivity : BaseActivity<ActivityHighScoreBinding>() {

    private val localStorage: LocalSharePreference by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHighScoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    private fun setupContent() = with(binding) {
        localStorage.getHighScores().let {
            txtHighscore1s.text = getString(R.string.text_1s_format, it.oneSec)
            txtHighscore3s.text = getString(R.string.text_3s_format, it.threeSec)
            txtHighscore5s.text = getString(R.string.text_5s_format, it.fiveSec)
            txtHighscore10s.text = getString(R.string.text_10s_format, it.tenSec)
            txtHighscore30s.text = getString(R.string.text_30s_format, it.thirtySec)
            txtHighscore60s.text = getString(R.string.text_60s_format, it.sixtySec)
        }
    }

    private fun setListener() {
        binding.imgBack.setOnClickListener { finish() }
    }

}
