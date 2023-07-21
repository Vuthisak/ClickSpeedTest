package com.example.clickspeedtest.feature.selectmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.clickspeedtest.R
import com.example.clickspeedtest.base.BaseActivity
import com.example.clickspeedtest.databinding.ActivitySelecteModeBinding
import com.example.clickspeedtest.feature.main.MainActivity
import com.example.clickspeedtest.feature.selectmode.adapter.SelectModeAdapter
import com.example.clickspeedtest.util.GeneralUtils
import com.example.network.model.SelectMode

class SelectModeActivity : BaseActivity<ActivitySelecteModeBinding>(),
    SelectModeAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelecteModeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setupContent()
        setListener()
    }

    override fun onItemClicked(selectMode: SelectMode) {
        MainActivity.start(this, selectMode.mode.rawValue)
    }

    private fun setupContent() {
        val adapter = SelectModeAdapter(GeneralUtils.getSelectModeItems(this), this)
        binding.selectModeRecycler.adapter = adapter
    }

    private fun setListener() {
        binding.imgBack.setOnClickListener { finish() }
    }

}
