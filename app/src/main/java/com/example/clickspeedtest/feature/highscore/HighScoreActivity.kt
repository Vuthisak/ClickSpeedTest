package com.example.clickspeedtest.feature.highscore

import android.os.Bundle
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityHighScoreBinding

class HighScoreActivity : BaseActivity<ActivityHighScoreBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHighScoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.imgBack.setOnClickListener { finish() }
    }

}
