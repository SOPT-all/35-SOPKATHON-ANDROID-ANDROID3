package com.example.sopkathon_android_team3.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sopkathon_android_team3.presentation.component.BasicLottie
import com.example.sopkathon_android_team3.presentation.home.component.HomeDescriptionDialog
import com.example.sopkathon_android_team3.presentation.type.CrystalAnimation
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToStorage: () -> Unit,
    viewModel: HomeViewModel = viewModel()

) {
    var showDialog by remember { mutableStateOf(false) }
    val animation by viewModel.animation.collectAsState()

    if (showDialog) {
        HomeDescriptionDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = { showDialog = false }
        )
    }
    LaunchedEffect(Unit) {
        viewModel.fetchAnimation(count = 3)
    }
    HomeScreen(
        modifier = Modifier.padding(padding),
        animation = animation,
        onNavigateToStorage = onNavigateToStorage,
    )
}

@Composable
private fun HomeScreen(
    onNavigateToStorage: () -> Unit,
    animation: CrystalAnimation,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        BasicLottie(crystalAnimation = animation.jsonFileName)
    }
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
