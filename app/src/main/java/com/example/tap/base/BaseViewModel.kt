package com.example.tap.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val composite = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        composite.clear()
    }

}