package com.example.tap.di

import com.example.tap.feature.root.RootViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { RootViewModel(get()) }
}