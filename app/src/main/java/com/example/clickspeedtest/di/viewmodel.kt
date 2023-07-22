package com.example.clickspeedtest.di

import com.example.clickspeedtest.feature.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { StartViewModel(get()) }
}