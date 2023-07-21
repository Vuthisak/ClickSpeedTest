package com.example.network.model

import com.google.gson.annotations.SerializedName

data class HighScores(
    @SerializedName("one_sec")
    val oneSec: Int = 0,
    @SerializedName("three_sec")
    val threeSec: Int = 0,
    @SerializedName("five_sec")
    val fiveSec: Int = 0,
    @SerializedName("ten_sec")
    val tenSec: Int = 0,
    @SerializedName("thirty_sec")
    val thirtySec: Int = 0,
    @SerializedName("sixty_sec")
    val sixtySec: Int = 0
)