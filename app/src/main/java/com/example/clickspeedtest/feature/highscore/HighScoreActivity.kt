package com.example.clickspeedtest.feature.highscore

import android.os.Bundle
import com.example.clickspeedtest.R
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityHighScoreBinding
import com.example.network.storage.LocalSharePreference

class HighScoreActivity : BaseActivity<ActivityHighScoreBinding>() {

    private val localStorage by lazy {
        LocalSharePreference(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHighScoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    private fun setupContent() {
        localStorage.getHighScores().apply {
            binding.txtHighscore1s.text = getString(R.string.text_1s_format, oneSec)
            binding.txtHighscore3s.text = getString(R.string.text_3s_format, threeSec)
            binding.txtHighscore5s.text = getString(R.string.text_5s_format, fiveSec)
            binding.txtHighscore10s.text = getString(R.string.text_10s_format, tenSec)
            binding.txtHighscore30s.text = getString(R.string.text_30s_format, thirtySec)
            binding.txtHighscore60s.text = getString(R.string.text_60s_format, sixtySec)
        }
    }

    private fun setListener() {
        binding.imgBack.setOnClickListener { finish() }
    }

}
