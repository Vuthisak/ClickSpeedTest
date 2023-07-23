package com.example.tap.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    protected inline fun checkIfOnDarkMode(crossinline onResult: () -> Unit) {
        val uiMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (uiMode == Configuration.UI_MODE_NIGHT_YES) {
            onResult()
        }
    }

}
