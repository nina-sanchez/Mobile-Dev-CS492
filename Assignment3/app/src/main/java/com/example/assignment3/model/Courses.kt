// Regina Sanchez
// OSU
// CS 492

package com.example.assignment3.model
import androidx.annotation.StringRes

data class Courses (
    @StringRes val title: Int,
    val department: String,
    val number: Int,
    val capacity: Int)