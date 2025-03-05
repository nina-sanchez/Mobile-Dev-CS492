// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val SoftStone = Color(0xFFEBE6E1)
val MistyBlue = Color(0xFFB0C4DE)
val LightTaupe = Color(0xFFD8C8B9)
val DeepNavy = Color(0xFF2C3E50)


private val LightColors = lightColorScheme(
    primary = MistyBlue,
    secondary = WarmBeige,
    tertiary = Peach,
    background = SoftStone,
    surface = LightTaupe,
    onPrimary = DeepNavy,
    onSecondary = DeepNavy,
    onBackground = DeepNavy,
    onSurface = DeepNavy
)

@Composable
fun MyCityTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}