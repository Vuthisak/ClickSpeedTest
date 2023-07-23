package com.example.tap.util

import com.example.network.model.Rating
import com.example.network.model.enums.SelectModeType

object GeneralUtils {

    fun getRating(modeType: SelectModeType, score: Int): Rating {
        return Rating().init(modeType, score);
    }

}
