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

    companion object {
        private const val SHARE_PREFERENCES_KEY = "CLICK_ME"
        private const val HIGH_SCORES = "HIGH_SCORES"
    }

}
