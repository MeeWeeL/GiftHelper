package com.meeweel.core.ui_base.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val TextHeaderColor = Color(0xFF1A1E1E)
val TextTitleColor = Color(0xFF1A1E1E)
val CardBackground = Color(0xFFCFCFCF)

val LocalColors = staticCompositionLocalOf { LightColorScheme }

val DarkColorScheme = getEmColors(
    material = darkColorScheme(),
    headerText = Color(0xFFFFFFFF),
)

val LightColorScheme = getEmColors(
    material = lightColorScheme(),
)

fun getEmColors(
    material: ColorScheme,
    headerText: Color = TextHeaderColor,
) = MeColors(
    material = material,
    headerText = headerText,
)

data class MeColors(
    val material: ColorScheme,
    val headerText: Color = TextHeaderColor,
    val titleText: Color = TextTitleColor,
    val cardBackground: Color = CardBackground,
)