package com.example.clickspeedtest.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val composite = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
    }

}