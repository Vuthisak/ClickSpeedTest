package com.example.clickspeedtest.feature.start

import android.os.Bundle
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivityStartBinding

class StartActivity : BaseActivity<ActivityStartBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        checkIfOnDarkMode {

        }
    }

}
