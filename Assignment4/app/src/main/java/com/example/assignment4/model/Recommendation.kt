package com.example.assignment4.model
import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Recommendation(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val address: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
