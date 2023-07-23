package com.example.tap.di

import com.example.network.api.ApiClient
import com.example.network.api.ApiService
import com.example.network.repository.LocationRepository
import com.example.network.repository.LocationRepositoryImpl
import com.example.network.storage.LocalSharePreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModules = module {
    single { ApiClient.getInstance().create(ApiService::class.java) }
    single { LocalSharePreference(androidContext()) }
    factory<LocationRepository> { LocationRepositoryImpl(get(), get()) }
}