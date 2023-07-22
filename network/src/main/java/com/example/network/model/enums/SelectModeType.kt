package com.example.network.model.enums

import com.example.network.model.HighScores
import com.example.network.storage.LocalSharePreference

enum class SelectModeType(val rawValue: Int) {
    ONE_SEC(1),
    THREE_SEC(2),
    FIVE_SEC(3),
    TEN_SEC(4),
    THIRTY_SEC(5),
    SIXTY_SEC(6);

    companion object {
        fun getMillisecond(mode: Int): Long {
            return when (mode) {
                ONE_SEC.rawValue -> 1000L
                THREE_SEC.rawValue -> 3000L
                FIVE_SEC.rawValue -> 5000L
                TEN_SEC.rawValue -> 10000L
                THIRTY_SEC.rawValue -> 30000L
                SIXTY_SEC.rawValue -> 60000L
                else -> 0L
            }
        }

        fun getCurrentModeType(mode: Int): SelectModeType {
            return when (mode) {
                THREE_SEC.rawValue -> THREE_SEC
                FIVE_SEC.rawValue -> FIVE_SEC
                TEN_SEC.rawValue -> TEN_SEC
                THIRTY_SEC.rawValue -> THIRTY_SEC
                SIXTY_SEC.rawValue -> SIXTY_SEC
                else -> ONE_SEC
            }
        }

        fun updateHighScores(
            selectModeType: SelectModeType,
            score: Int,
            highScores: HighScores
        ): HighScores {
            when (selectModeType) {
                ONE_SEC -> highScores.oneSec = score
                THREE_SEC -> highScores.threeSec = score
                FIVE_SEC -> highScores.fiveSec = score
                TEN_SEC -> highScores.tenSec = score
                THIRTY_SEC -> highScores.thirtySec = score
                SIXTY_SEC -> highScores.sixtySec = score
            }
            return highScores
        }

        fun getCurrentHighScore(mode: SelectModeType, highScores: HighScores): Int {
            return when (mode) {
                ONE_SEC -> highScores.oneSec
                THREE_SEC -> highScores.threeSec
                FIVE_SEC -> highScores.fiveSec
                TEN_SEC -> highScores.tenSec
                THIRTY_SEC -> highScores.thirtySec
                SIXTY_SEC -> highScores.sixtySec
            }
        }
    }
}