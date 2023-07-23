package com.example.tap.feature.start

import com.example.network.repository.LocationRepository
import com.example.tap.base.BaseViewModel
import com.example.tap.util.addTo
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
                // no implementation
            }, {
                // no implementation
            }).addTo(composite)
    }

}
