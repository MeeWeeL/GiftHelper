package com.meeweel.ui_base.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.meeweel.ui_base.theme.color.CardBackground
import com.meeweel.ui_base.theme.color.TextHeaderColor
import com.meeweel.ui_base.theme.color.TextTitleColor
import com.meeweel.ui_base.theme.typography.Typography

private val LocalColors = staticCompositionLocalOf { LightColorScheme }

private val DarkColorScheme = getEmColors(
    material = darkColorScheme(),
    headerText = Color(0xFFFFFFFF),
)

private val LightColorScheme = getEmColors(
    material = lightColorScheme(),
)

fun getEmColors(
    material: ColorScheme,
    headerText: Color = TextHeaderColor,
) = MeColors(
    material = material,
    headerText = headerText,
)

@Composable
fun MeTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
            if (darkTheme) DarkColorScheme //getEmColors(dynamicDarkColorScheme(context))
            else LightColorScheme //getEmColors(dynamicLightColorScheme(context))
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )
        }
    }

    CompositionLocalProvider(LocalColors provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.material,
            typography = Typography,
            content = content
        )
    }
}

data class MeColors(
    val material: ColorScheme,
    val headerText: Color = TextHeaderColor,
    val titleText: Color = TextTitleColor,
    val cardBackground: Color = CardBackground,
)

object MeTheme {

    val colors: MeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}