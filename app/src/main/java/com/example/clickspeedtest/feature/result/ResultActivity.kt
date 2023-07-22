package com.example.clickspeedtest.feature.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.clickspeedtest.R
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityResultBinding
import com.example.clickspeedtest.feature.main.MainActivity
import com.example.clickspeedtest.feature.start.StartActivity
import com.example.clickspeedtest.util.GeneralUtils
import com.example.network.model.HighScores
import com.example.network.model.enums.SelectModeType
import com.example.network.storage.LocalSharePreference
import org.koin.android.ext.android.inject

class ResultActivity : BaseActivity<ActivityResultBinding>() {

    private val localStorage by inject<LocalSharePreference>()

    private lateinit var highScores: HighScores
    private var mode: SelectModeType = SelectModeType.ONE_SEC
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupData()
        setupContent()
        setListener()
    }

    private fun setupData() {
        highScores = localStorage.getHighScores()
    }

    private fun setupContent() = with(binding) {
        mode = SelectModeType.getCurrentModeType(intent.getIntExtra(MODE, 0))
        score = intent.getIntExtra(SCORE, 0)
        setupHighScore()
        txtResult.text = score.toString()
        setupRating()
    }

    private fun setupHighScore() = with(binding) {
        val currentHighScore = SelectModeType.getCurrentHighScore(mode, highScores)
        val stringId = if (score > currentHighScore) {
            highScores = SelectModeType.updateHighScores(mode, score, highScores)
            localStorage.saveHighScores(highScores)
            R.string.text_new_high_score_format
        } else {
            R.string.text_high_score_format
        }
        txtHighScore.text = getString(stringId, score)
    }

    private fun setupRating() = with(binding) {
        val rating = GeneralUtils.getRating(mode, score)
        if (rating.isValid()) {
            ratingResult.rating = rating.rating.toFloat()
            txtRatingText.text = getString(rating.ratingText)
        }
    }

    private fun setListener() = with(binding) {
        imgBack.setOnClickListener { StartActivity.start(this@ResultActivity) }
        imgRefresh.setOnClickListener {
            finish()
            MainActivity.start(this@ResultActivity, mode.rawValue)
        }
    }

    companion object {
        private const val MODE = "Mode"
        private const val SCORE = "Score"

        fun start(context: Context, mode: Int, score: Int) {
            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra(MODE, mode)
            intent.putExtra(SCORE, score)
            context.startActivity(intent)
        }
    }

}
