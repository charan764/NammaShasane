package com.example.nammashasane.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(

    primary = WhiteText,

    secondary = LightGrey,

    background = AppBlack,

    surface = DarkGrey,

    onPrimary = BlackText,

    onBackground = WhiteText,

    onSurface = WhiteText
)

@Composable
fun NammaShasaneTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = DarkColors,

        content = content
    )
}