package com.example.network.repository

import com.example.network.api.ApiClient
import com.example.network.api.ApiService
import com.example.network.model.GeoLocation
import io.reactivex.rxjava3.core.Single

class LocationRepositoryImpl(
    val apiService: ApiService
) : LocationRepository {

    override fun getLocation(): Single<GeoLocation> {
        return apiService.getGeolocation()
    }

}
