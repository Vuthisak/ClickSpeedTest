package com.example.network.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.example.network.model.HighScores
import com.google.gson.Gson

class LocalSharePreference(
    context: Context
) {

    private val sharePreference = context.getSharedPreferences(SHARE_PREFERENCES_KEY, MODE_PRIVATE)
    private val gson by lazy { Gson() }

    fun saveHighScores(highScores: HighScores) {
        try {
            sharePreference.edit {
                val jsonString = gson.toJson(highScores)
                putString(HIGH_SCORES, jsonString)
            }
        } catch (ex: Exception) {
            // ignore
        }
    }

    fun getHighScores(): HighScores {
        return try {
            val jsonString = sharePreference.getString(HIGH_SCORES, "")
            gson.fromJson(jsonString, HighScores::class.java)
        } catch (ex: Exception) {
            HighScores()
        }
    }

    fun saveCountryName(countryName: String) {
        if (getCountryName() != null) return
        try {
            sharePreference.edit {
                putString(COUNTRY_NAME, countryName.lowercase())
            }
        } catch (ex: Exception) {
            // ignore
        }
    }

    fun getCountryName(): String? {
        return try {
            sharePreference.getString(COUNTRY_NAME, null)
        } catch (ex: Exception) {
            null
        }
    }

    fun setUserAlreadyRateApp() {
        try {
            sharePreference.edit {
                putBoolean(RATE_APP, true)
            }
        } catch (ex: Exception) {
            // ignore
        }
    }

    fun isUserAlreadyRateApp(): Boolean =
        try {
            sharePreference.getBoolean(RATE_APP, false)
        } catch (ex: Exception) {
            false
        }

    companion object {
        private const val RATE_APP = "RATE_APP"
        private const val SHARE_PREFERENCES_KEY = "CLICK_ME"
        private const val HIGH_SCORES = "HIGH_SCORES"
        private const val COUNTRY_NAME = "COUNTRY_NAME"
    }

}
