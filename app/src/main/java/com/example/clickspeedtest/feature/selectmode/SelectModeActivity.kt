package com.example.clickspeedtest.feature.selectmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickspeedtest.R
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivitySelecteModeBinding

class SelectModeActivity : BaseActivity<ActivitySelecteModeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelecteModeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

}
