package com.example.clickspeedtest.feature.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityMainBinding
import com.example.clickspeedtest.feature.result.ResultActivity
import com.example.network.model.enums.SelectModeType
import java.util.Timer
import java.util.TimerTask

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var clickCount = 0
    private var millis: Long = 0L
    private var time: Int = 0
    private var mode: Int = 0
    private var clickCountTemp = 0
    private var speed: Long = 1000
    private var handler = Handler(Looper.getMainLooper())

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    private fun setupContent() {
        mode = intent.extras?.getInt(MODE) ?: 0
        millis = SelectModeType.getMillisecond(mode)
        Log.d("@@@", millis.toString())
        binding.progressTimeLeft.max = millis.toInt()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() = with(binding) {
        root.setOnTouchListener { _, event ->
            val action = event.actionMasked
            val pointerCount = event.pointerCount
            when (action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                    startTime(millis.toInt())
                    clickCount += pointerCount
                    binding.txtCurrentPoint.text = clickCount.toString()
                    clickCountTemp++
                    handler.removeCallbacksAndMessages(null)
                    handler.postDelayed(object : Runnable {
                        override fun run() {
                            if (clickCount > 0) {
                                val clicksPerSecond: Long = 1000 / speed * clickCountTemp
                                binding.txtCurrentCps.text = "$clicksPerSecond"
                                clickCountTemp = 0
                            } else {
                                speed += 100 // increase delay time by 100ms
                            }
                            handler.postDelayed(this, speed)
                        }
                    }, speed)
                }
            }
            true
        }
    }

    private fun startTime(millisInInt: Int) {
        if (this::timer.isInitialized) return
        timer = Timer()
        val period: Long = (millis * 0.04).toLong()
        val periodInInt = period.toInt()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                time += periodInInt
                runOnUiThread { binding.progressTimeLeft.progress = time }
                if (time == millisInInt) {
                    finish()
                    ResultActivity.start(this@MainActivity, mode, clickCount)
                }
            }
        }, 0, period)
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
