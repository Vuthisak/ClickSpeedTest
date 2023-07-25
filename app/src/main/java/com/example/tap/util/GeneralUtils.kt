package com.example.tap.util

import androidx.annotation.CheckResult
import androidx.lifecycle.LiveData
import com.example.network.model.Rating
import com.example.network.model.enums.SelectModeType

object GeneralUtils {

    fun getRating(modeType: SelectModeType, score: Int): Rating {
        return Rating().init(modeType, score);
    }

}

typealias LiveDataObserver <T> = (T) -> Unit

@CheckResult
fun <T> LiveData<T>.startObserveForever(observer: LiveDataObserver<T>): LiveDataObserver<T> {
    observeForever(observer)
    return observer
}
