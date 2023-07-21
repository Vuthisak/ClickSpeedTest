package com.example.clickspeedtest.feature.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityMainBinding
import com.example.network.model.enums.SelectModeType
import java.util.Locale
import kotlin.math.roundToInt

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var clickCount = 0
    private var isRunning = false
    private var timer: CountDownTimer? = null
    private var millis: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    private fun setupContent() {
        val mode = intent.extras?.getInt(MODE) ?: 0
        millis = SelectModeType.getMillisecond(mode)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() {
        binding.root.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                clickCount = 0
                timer = object : CountDownTimer(millis, 100) {
                    override fun onTick(millisUntilFinished: Long) {
                        // Do nothing
                        val clickSpeed = (clickCount.toDouble() / 5).roundToInt()
                        binding.txtCurrentCpsLabel.text = clickSpeed.toString()
                    }

                    override fun onFinish() {
                        isRunning = false
                    }
                }
                (timer as CountDownTimer).start()
            }
            clickCount++
            binding.txtCurrentPoint.text = clickCount.toString()
        }
    }

    companion object {
        private const val MODE = "Mode"

        fun start(context: Context, mode: Int) {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(MODE, mode)
            context.startActivity(intent)
        }
    }

}
