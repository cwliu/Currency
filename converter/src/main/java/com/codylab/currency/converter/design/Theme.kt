package com.codylab.currency.converter.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.codylab.currency.ui.theme.Red200
import com.codylab.currency.ui.theme.Red500
import com.codylab.currency.ui.theme.Red700
import com.codylab.currency.ui.theme.Teal200

private val DarkColorPalette = darkColors(
    primary = Red200,
    primaryVariant = Red700,
    secondary = Teal200
)
private val LightColorPalette = lightColors(
    primary = Red500,
    primaryVariant = Red700,
    secondary = Teal200
)

@Composable
fun CurrencyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}