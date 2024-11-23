package com.example.sopkathon_android_team3.presentation.storage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import com.example.sopkathon_android_team3.ui.theme.SopkathonAndroidTeam3Theme

@Composable
fun StorageRoute(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit
) {
    StorageScreen(
        modifier = Modifier.padding(padding),
        onNavigateToHome = onNavigateToHome
    )
}

@Composable
private fun StorageScreen(
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.clickable(onClick = onNavigateToHome),
        text = "This is Storage Screen",
        color = SopkathonAndroidTeam3Theme.colors.white
    )
}

@Preview
@Composable
private fun StorageRoutePreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        StorageRoute(
            padding = PaddingValues(),
            onNavigateToHome = {}
        )
    }
}
