package com.example.network.api

import com.example.network.model.GeoLocation
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/ipgeo")
    fun getGeolocation(): Single<GeoLocation>
}