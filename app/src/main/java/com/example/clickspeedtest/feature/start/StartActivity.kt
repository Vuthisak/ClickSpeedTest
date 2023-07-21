package com.example.clickspeedtest.feature.start

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityStartBinding
import com.example.clickspeedtest.feature.highscore.HighScoreActivity
import com.example.clickspeedtest.feature.selectmode.SelectModeActivity

class StartActivity : BaseActivity<ActivityStartBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        checkIfOnDarkMode {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        setListener()
    }

    private fun setListener() = with(binding) {
        root.setOnClickListener { gotoSelectModeScreen() }
        imgBarChart.setOnClickListener { gotoHighScoreScreen() }
    }

    private fun gotoSelectModeScreen() {
        val intent = Intent(this, SelectModeActivity::class.java)
        startActivity(intent)
    }

    private fun gotoHighScoreScreen() {
        val intent = Intent(this, HighScoreActivity::class.java)
        startActivity(intent)
    }

}
