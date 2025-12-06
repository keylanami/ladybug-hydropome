package com.example.hydropome.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



// ----------------------------------------------------
// COLOR SCHEME — Light Theme
// ----------------------------------------------------
private val LightColorScheme = lightColorScheme(
    primary = GreenNormal,
    onPrimary = Color.White,
    primaryContainer = GreenLight,
    onPrimaryContainer = GreenDarker,

    secondary = OrangeNormal,
    onSecondary = Color.White,
    secondaryContainer = OrangeLight,
    onSecondaryContainer = OrangeDarker,

    background = BgLight,
    onBackground = BlackNormal,

    surface = Color.White,
    onSurface = BlackNormal,

    outline = BlackLight,
)

// ----------------------------------------------------
// COLOR SCHEME — Dark Theme
// ----------------------------------------------------
private val DarkColorScheme = darkColorScheme(
    primary = GreenLight,
    onPrimary = GreenDark,
    primaryContainer = GreenDarker,
    onPrimaryContainer = GreenLight,

    secondary = OrangeLight,
    onSecondary = OrangeDarker,
    secondaryContainer = OrangeDark,
    onSecondaryContainer = OrangeLight,

    background = BgDark,
    onBackground = Color.White,

    surface = BgNormal,
    onSurface = Color.White,

    outline = BlackDark,
)


@Composable
fun HydropomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
