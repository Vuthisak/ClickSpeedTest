package com.example.network.model

import com.example.network.R
import com.example.network.model.enums.SelectModeType

data class Rating(
    var rating: Int = 0,
    var ratingText: Int = -1
) {

    fun isValid(): Boolean = rating > 0 && ratingText != -1

    fun init(mode: SelectModeType, score: Int): Rating {
        when (mode) {
            SelectModeType.ONE_SEC -> generateOneRating(score)
            SelectModeType.THREE_SEC -> generateThreeSecRating(score)
            SelectModeType.FIVE_SEC -> generateFiveSecRating(score)
            SelectModeType.TEN_SEC -> generateTenSecRating(score)
            SelectModeType.THIRTY_SEC -> generateThirtySecRating(score)
            SelectModeType.SIXTY_SEC -> generateSixtySecRating(score)
        }
        return this
    }

    private fun generateOneRating(score: Int) {
        when {
            score in 1..6 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            score in 7..10 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            score in 11..14 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            score in 15..18 -> {
                rating = 4
                ratingText = R.string.text_level_4
            }

            else -> {
                rating = 5
                ratingText = R.string.text_level_5
            }
        }
    }

    private fun generateThreeSecRating(score: Int) {
        when {
            score in 1..10 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            score in 10..14 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            score in 15..18 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            score in 18..24 -> {
                rating = 4
                ratingText = R.string.text_level_4
            }

            else -> {
                rating = 5
                ratingText = R.string.text_level_5
            }
        }
    }

    private fun generateFiveSecRating(score: Int) {

    }

    private fun generateTenSecRating(score: Int) {

    }

    private fun generateThirtySecRating(score: Int) {

    }


    private fun generateSixtySecRating(score: Int) {

    }

}
