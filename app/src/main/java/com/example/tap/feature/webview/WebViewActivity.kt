package com.example.tap.feature.webview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.example.tap.base.BaseActivity
import com.example.tap.databinding.ActivityWebViewBinding


class WebViewActivity : BaseActivity<ActivityWebViewBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setListener()
    }

    private fun setListener() = with(binding) {
        imgClose.setOnClickListener { finish() }
        btnGoogle.setOnClickListener {
            openBrowser("https://www.google.com")
        }
        btnTwitter.setOnClickListener {
            openBrowser("https://www.twitter.com")
        }
    }

    private fun openBrowser(urlString: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
        startActivity(browserIntent)
    }

}