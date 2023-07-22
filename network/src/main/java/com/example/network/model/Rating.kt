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
        when (score) {
            in 1..6 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            in 7..10 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            in 11..14 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            in 15..18 -> {
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
        when (score) {
            in 1..30 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            in 31..54 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            in 55..70 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            in 70..100 -> {
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
        when (score) {
            in 1..60 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            in 61..90 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            in 91..120 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            in 121..150 -> {
                rating = 4
                ratingText = R.string.text_level_4
            }

            else -> {
                rating = 5
                ratingText = R.string.text_level_5
            }
        }
    }

    private fun generateTenSecRating(score: Int) {
        when (score) {
            in 1..100 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            in 101..130 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            in 131..170 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            in 171..190 -> {
                rating = 4
                ratingText = R.string.text_level_4
            }

            else -> {
                rating = 5
                ratingText = R.string.text_level_5
            }
        }
    }

    private fun generateThirtySecRating(score: Int) {
        when (score) {
            in 1..200 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            in 201..350 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            in 351..450 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            in 451..550 -> {
                rating = 4
                ratingText = R.string.text_level_4
            }

            else -> {
                rating = 5
                ratingText = R.string.text_level_5
            }
        }
    }


    private fun generateSixtySecRating(score: Int) {
        when (score) {
            in 1..500 -> {
                rating = 1
                ratingText = R.string.text_level_1
            }

            in 501..600 -> {
                rating = 2
                ratingText = R.string.text_level_2
            }

            in 601..740 -> {
                rating = 3
                ratingText = R.string.text_level_3
            }

            in 741..820 -> {
                rating = 4
                ratingText = R.string.text_level_4
            }

            else -> {
                rating = 5
                ratingText = R.string.text_level_5
            }
        }
    }

}
