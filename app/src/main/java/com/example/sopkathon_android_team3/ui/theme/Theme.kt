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
    val typography: SopkathonAndroidTeam3Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonAndroidTeam3Typography.current
}

@Composable
fun ProvideSopkathonAndroidTeam3ColorsAndTypography(
    colors: SopkathonAndroidTeam3Colors,
    typography: SopkathonAndroidTeam3Typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSopkathonAndroidTeam3Colors provides colors,
        LocalSopkathonAndroidTeam3Typography provides typography,
        content = content
    )
}

@Composable
fun SOPKATHON_ANDROID_TEAM3Theme(
    content: @Composable () -> Unit
) {
    ProvideSopkathonAndroidTeam3ColorsAndTypography(
        colors = defaultSopkathonAndroidTeam3Colors,
        typography = defaultSopkathonAndroidTeam3Typography
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
            content = content
        )
    }
}
