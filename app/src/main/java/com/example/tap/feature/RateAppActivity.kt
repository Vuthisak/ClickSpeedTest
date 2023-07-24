package com.example.tap.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.network.storage.LocalSharePreference
import com.example.tap.R
import com.example.tap.base.BaseActivity
import com.example.tap.databinding.ActivityRateAppBinding
import org.koin.android.ext.android.inject

class RateAppActivity : BaseActivity<ActivityRateAppBinding>() {

    private val localStorage: LocalSharePreference by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRateAppBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    private fun setupContent() {
        Glide.with(this).load(R.drawable.ic_gif_thank_you).into(binding.imgThankYou)
    }

    private fun setListener() {
        binding.imgClose.setOnClickListener { finish() }
        binding.btnRateUs.setOnClickListener {
            localStorage.setUserAlreadyRateApp()
            finish()
            // TODO to implement
        }
    }

    companion object {
        fun start(context: Context) {
            Intent(context, RateAppActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

}
