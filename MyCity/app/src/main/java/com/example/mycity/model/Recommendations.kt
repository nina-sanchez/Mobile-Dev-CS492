// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendations(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val address: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
