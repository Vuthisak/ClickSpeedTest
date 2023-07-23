package com.example.tap

import android.app.Application
import com.example.tap.di.dataModules
import com.example.tap.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@AndroidApplication)
            modules(dataModules, viewModels)
        }
    }

}
