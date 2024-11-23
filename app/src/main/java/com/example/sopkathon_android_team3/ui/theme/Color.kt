package com.example.sopkathon_android_team3.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Pink = Color(0xFFC26ABD)
val Purple = Color(0xFF331046)

val White = Color(0xFFFFFFFF)
val Gray1 = Color(0xFFF9F9F9)
val Gray2 = Color(0xFFE5E5E5)
val Gray3 = Color(0xFFCCCCCC)
val Gray4 = Color(0xFFB8B8B8)
val Gray5 = Color(0xFFA3A3A3)
val Gray6 = Color(0xFF8F8F8F)
val Gray7 = Color(0xFF7A7A7A)
val Gray8 = Color(0xFF666666)
val Gray9 = Color(0xFF525252)
val Black = Color(0xFF222222)

@Immutable
data class SopkathonAndroidTeam3Colors(
    val pink: Color,
    val purple: Color,

    val white: Color,
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color,
    val gray7: Color,
    val gray8: Color,
    val gray9: Color,
    val black: Color
)

val defaultSopkathonAndroidTeam3Colors = SopkathonAndroidTeam3Colors(
    pink = Pink,
    purple = Purple,

    white = White,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    gray5 = Gray5,
    gray6 = Gray6,
    gray7 = Gray7,
    gray8 = Gray8,
    gray9 = Gray9,
    black = Black
)

val LocalSopkathonAndroidTeam3Colors = staticCompositionLocalOf { defaultSopkathonAndroidTeam3Colors }
