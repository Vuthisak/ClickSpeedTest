package com.example.network.repository

import com.example.network.api.ApiService
import com.example.network.model.GeoLocation
import com.example.network.storage.LocalSharePreference
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class LocationRepositoryImpl(
    private val localStorage: LocalSharePreference,
    private val apiService: ApiService
) : LocationRepository {

    override fun getLocation(): Single<GeoLocation> {
        return apiService
            .getGeolocation()
            .subscribeOn(Schedulers.io())
            .map { geoLocation ->
                localStorage.saveCountryName(geoLocation.countryName)
                geoLocation
            }
    }

}
