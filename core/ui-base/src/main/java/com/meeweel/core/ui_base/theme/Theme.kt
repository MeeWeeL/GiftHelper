package com.meeweel.core.ui_base.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.meeweel.core.ui_base.theme.color.DarkColorScheme
import com.meeweel.core.ui_base.theme.color.LightColorScheme
import com.meeweel.core.ui_base.theme.color.LocalColors
import com.meeweel.core.ui_base.theme.color.MeColors
import com.meeweel.core.ui_base.theme.typography.MeTypography

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
            typography = MeTheme.typography.typography,
            content = content
        )
    }
}

object MeTheme {

    val colors: MeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: MeTypography
        @Composable
        @ReadOnlyComposable
        get() = MeTypography
}