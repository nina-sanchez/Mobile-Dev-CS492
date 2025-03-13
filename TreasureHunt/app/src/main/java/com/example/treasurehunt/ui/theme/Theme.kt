package com.example.treasurehunt.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color


// Define your light color scheme
private val LightColorScheme = lightColorScheme(
    primary = MistyBlue,
    secondary = Peach,
    tertiary = WarmBeige,
    background = SoftStone,
    surface = LightTaupe,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = DarkText,
    onSurface = DarkText
)


@Composable
fun TreasureHuntTheme(
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Always use the LightColorScheme
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Ensure Typography is defined
        content = content
    )
}
