package com.example.tap.feature.highscore

import android.os.Bundle
import com.example.tap.base.BaseActivity
import com.example.network.storage.LocalSharePreference
import com.example.tap.databinding.ActivityHighScoreBinding
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
            txtHighscore60s.text = it.sixtySec.toString()
        }
    }

    private fun setListener() {
        binding.imgBack.setOnClickListener { finish() }
    }

}
