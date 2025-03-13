// Regina Sanchez
// OSU
// CS492

package com.example.treasurehunt.data

import android.content.Context
import com.example.treasurehunt.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// data class for clues
data class Clue(
    val clue: String,
    val hint: String,
    val latitude: Double,
    val longitude: Double,
    val info: String
)

// loading in from json file
fun loadClues(context: Context): List<Clue> {
    val inputStream = context.resources.openRawResource(R.raw.clues)
    val json = inputStream.bufferedReader().use { it.readText() }
    val type = object : TypeToken<List<Clue>>() {}.type
    return Gson().fromJson(json, type)
}
