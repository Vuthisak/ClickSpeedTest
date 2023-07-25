package com.example.tap.feature.root

sealed class RootState {
    object Loading : RootState()
    object Finished : RootState()
    data class GetLocationSuccess(val countryName: String) : RootState()
    object Error : RootState()
}