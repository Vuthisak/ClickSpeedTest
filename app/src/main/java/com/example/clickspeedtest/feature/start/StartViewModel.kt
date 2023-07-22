package com.example.clickspeedtest.feature.start

import android.util.Log
import androidx.annotation.MainThread
import com.example.clickspeedtest.base.BaseViewModel
import com.example.clickspeedtest.util.addTo
import com.example.network.repository.LocationRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StartViewModel(
    private val repository: LocationRepository
) : BaseViewModel() {

    fun initLocation() {
        repository.getLocation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("@@@", it.countryName)
            }, {
                Log.d("@@@", "Error: $it")
            }).addTo(composite)
    }

}
