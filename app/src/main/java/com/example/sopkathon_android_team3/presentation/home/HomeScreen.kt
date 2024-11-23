package com.example.sopkathon_android_team3.presentation.home

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
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToStorage: () -> Unit
) {
    HomeScreen(
        modifier = Modifier.padding(padding),
        onNavigateToStorage = onNavigateToStorage
    )
}

@Composable
private fun HomeScreen(
    onNavigateToStorage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.clickable(onClick = onNavigateToStorage),
        text = "This is Home Screen",
        color = SopkathonAndroidTeam3Theme.colors.white
    )
}

@Preview
@Composable
private fun HomeRoutePreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        HomeRoute(
            padding = PaddingValues(),
            onNavigateToStorage = {}
        )
    }
}
