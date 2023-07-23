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
            txtHighscore60s.text = it.sixtySec.toString()
        }
    }

    private fun setListener() {
        binding.imgBack.setOnClickListener { finish() }
    }

}
