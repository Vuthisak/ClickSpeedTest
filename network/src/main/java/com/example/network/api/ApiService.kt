package com.example.network.api

import com.example.network.model.GeoLocation
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/ipgeo?apiKey=26a0f31b8a7c4b769224e69fc168b7fb")
    fun getGeolocation(): Single<GeoLocation>
}