package com.example.clickspeedtest.util

import android.content.Context
import com.example.clickspeedtest.R
import com.example.network.model.Rating
import com.example.network.model.SelectMode
import com.example.network.model.enums.SelectModeType

object GeneralUtils {

    fun getSelectModeItems(context: Context): MutableList<SelectMode> {
        return mutableListOf<SelectMode>().apply {
            add(SelectMode(SelectModeType.ONE_SEC, context.getString(R.string.text_1s)))
            add(SelectMode(SelectModeType.THREE_SEC, context.getString(R.string.text_3s)))
            add(SelectMode(SelectModeType.FIVE_SEC, context.getString(R.string.text_5s)))
            add(SelectMode(SelectModeType.TEN_SEC, context.getString(R.string.text_10s)))
            add(SelectMode(SelectModeType.THIRTY_SEC, context.getString(R.string.text_30s)))
            add(SelectMode(SelectModeType.SIXTY_SEC, context.getString(R.string.text_60s)))
        }
    }

    fun getRating(modeType: SelectModeType, score: Int): Rating {
        return Rating().init(modeType, score);
    }

}
