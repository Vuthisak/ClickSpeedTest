package com.example.network.model

import com.google.gson.annotations.SerializedName

data class GeoLocation(
    @SerializedName("country_name")
    val countryName: String
)