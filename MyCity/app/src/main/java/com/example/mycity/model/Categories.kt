// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Categories(
    @StringRes val name: Int,
    @DrawableRes val image: Int
)
