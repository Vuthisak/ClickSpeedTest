package com.example.clickspeedtest.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickspeedtest.R
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityRateAppBinding

class RateAppActivity : BaseActivity<ActivityRateAppBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRateAppBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    fun setListener() {
        binding.imgClose.setOnClickListener { finish() }
        binding.btnRateUs.setOnClickListener {
            // TODO to implement
        }
    }

}
