package com.example.network.model

import com.google.gson.annotations.SerializedName

data class HighScores(
    @SerializedName("one_sec")
    var oneSec: Int = 0,
    @SerializedName("three_sec")
    var threeSec: Int = 0,
    @SerializedName("five_sec")
    var fiveSec: Int = 0,
    @SerializedName("ten_sec")
    var tenSec: Int = 0,
    @SerializedName("thirty_sec")
    var thirtySec: Int = 0,
    @SerializedName("sixty_sec")
    var sixtySec: Int = 0
)