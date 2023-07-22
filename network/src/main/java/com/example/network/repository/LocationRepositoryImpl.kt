package com.example.network.repository

import com.example.network.api.ApiService
import com.example.network.model.GeoLocation
import io.reactivex.Single

class LocationRepositoryImpl(
    val apiService: ApiService
) : LocationRepository {

    override fun getLocation(): Single<GeoLocation> {
        return apiService.getGeolocation()
    }

}
