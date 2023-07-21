package com.example.network.model.enums

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
                ONE_SEC.rawValue -> 100L
                THREE_SEC.rawValue -> 300L
                FIVE_SEC.rawValue -> 500L
                TEN_SEC.rawValue -> 1000L
                THREE_SEC.rawValue -> 3000L
                SIXTY_SEC.rawValue -> 6000L
                else -> 0L
            }
        }
    }
}