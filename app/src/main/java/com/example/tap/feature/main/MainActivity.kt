package com.example.tap.feature.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.RelativeLayout
import com.example.network.model.enums.SelectModeType
import com.example.tap.base.BaseActivity
import com.example.tap.databinding.ActivityMainBinding
import com.example.tap.feature.result.ResultActivity
import java.util.Random
import java.util.Timer
import java.util.TimerTask

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val handler: Handler = Handler(Looper.getMainLooper())

    private var touchCount = 0
    private var millis: Long = 0L
    private var time: Int = 0
    private var mode: Int = 0
    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
        timer = null
    }

    private fun setupContent() {
        mode = intent.extras?.getInt(MODE) ?: 0
        millis = SelectModeType.getMillisecond(mode)
        binding.progressTimeLeft.max = millis.toInt()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() = with(binding) {
        root.setOnClickListener { startTime(millis.toInt()) }
    }

    private fun generateCircle(value: Int) {
        val circleRadius = 100
        val circleColor = getRandomColor()
        val circleX = getRandomNumberInRange(
            circleRadius,
            Resources.getSystem().displayMetrics.widthPixels - circleRadius
        )
        val circleY = getRandomNumberInRange(
            circleRadius,
            Resources.getSystem().displayMetrics.heightPixels - circleRadius
        )

        val params = RelativeLayout.LayoutParams(circleRadius * 2, circleRadius * 2)
        params.setMargins(circleX - circleRadius, circleY - circleRadius, 0, 0)

        val circleView = CircleNumberView(this@MainActivity)
        circleView.setColor(circleColor)
        circleView.layoutParams = params
        circleView.setNumber(value)
        circleView.setOnClickListener {
            touchCount += value
            binding.txtCurrentPoint.text = touchCount.toString()
            binding.circleContainer.removeView(circleView)
        }

        binding.circleContainer.addView(circleView)

        handler.postDelayed({
            binding.circleContainer.removeView(circleView)
        }, 2500) // 3 seconds
    }

    private fun getRandomNumberInRange(min: Int, max: Int): Int {
        val random = Random()
        return random.nextInt(max - min + 1) + min
    }

    private fun getRandomColor(): Int {
        val random = Random()
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }

    private fun startTime(millisInInt: Int) {
        if (timer != null) return
        timer = Timer()
        val period: Long = (millis * 0.04).toLong()
        val periodInInt = period.toInt()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                time += periodInInt
                runOnUiThread {
                    for (i in 0..6) {
                        generateCircle(i + 1)
                    }
                    binding.progressTimeLeft.progress = time
                }
                if (time == millisInInt) {
                    finish()
                    ResultActivity.start(this@MainActivity, mode, touchCount)
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
