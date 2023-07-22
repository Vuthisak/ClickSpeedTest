package com.example.network.repository

import com.example.network.model.GeoLocation
import io.reactivex.Single

interface LocationRepository {
    fun getLocation(): Single<GeoLocation>
}