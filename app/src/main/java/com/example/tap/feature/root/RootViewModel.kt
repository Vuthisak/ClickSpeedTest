package com.example.tap.feature.root

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.network.repository.LocationRepository
import com.example.tap.base.BaseViewModel
import com.example.tap.util.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RootViewModel(
    private val repository: LocationRepository
) : BaseViewModel() {

    private val _state = MutableLiveData<RootState>()
    val state: LiveData<RootState> = _state

    fun initLocation() {
        repository.getLocation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _state.value = RootState.Loading }
            .doFinally { _state.value = RootState.Finished }
            .subscribe({ geoLocation ->
                _state.value = RootState.GetLocationSuccess(geoLocation.countryName)
            }, {
                _state.value = RootState.Error
            }).addTo(composite)
    }

}
