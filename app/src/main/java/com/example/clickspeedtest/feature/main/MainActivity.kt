package com.example.clickspeedtest.feature.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityMainBinding
import java.util.Locale
import kotlin.math.roundToInt

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var clickCount = 0
    private var isRunning = false
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() {
        binding.root.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                clickCount = 0
                timer = object : CountDownTimer(30000, 100) {
                    override fun onTick(millisUntilFinished: Long) {
                        // Do nothing
                        val clickSpeed = (clickCount.toDouble() / 5).roundToInt()
                        binding.txtCurrentCpsLabel.text = clickSpeed.toString()
                    }

                    override fun onFinish() {
                        isRunning = false
                        val clickSpeed = (clickCount.toDouble() / 10).roundToInt()
                        binding.txtCurrentCpsLabel.text = clickSpeed.toString()
                    }
                }
                (timer as CountDownTimer).start()
            }
            clickCount++
            binding.txtCurrentPoint.text = clickCount.toString()
        }
    }

    companion object {
        fun start() {
        }
    }

}
