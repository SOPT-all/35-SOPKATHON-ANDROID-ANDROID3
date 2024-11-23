package com.example.sopkathon_android_team3.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object SopkathonAndroidTeam3Theme {
    val colors: SopkathonAndroidTeam3Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonAndroidTeam3Colors.current
    // TODO: Typography 추가
}

@Composable
fun ProvideSopkathonAndroidTeam3ColorsAndTypography(
    colors: SopkathonAndroidTeam3Colors,
    // TODO: Typography 추가
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSopkathonAndroidTeam3Colors provides colors,
        // TODO: Typography 추가
        content = content
    )
}

@Composable
fun SOPKATHON_ANDROID_TEAM3Theme(
    content: @Composable () -> Unit
) {
    ProvideSopkathonAndroidTeam3ColorsAndTypography(
        colors = defaultSopkathonAndroidTeam3Colors
        // TODO: Typography 추가
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
        MaterialTheme(
            typography = Typography,
            // TODO: Typography 제거
            content = content
        )
    }
}