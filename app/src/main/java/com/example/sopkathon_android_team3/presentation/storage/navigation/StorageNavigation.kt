package com.example.sopkathon_android_team3.presentation.storage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.sopkathon_android_team3.presentation.model.Route
import com.example.sopkathon_android_team3.presentation.storage.StorageRoute

fun NavController.navigateStorage() {
    navigate(route = Route.Storage)
}

fun NavGraphBuilder.storageNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit
) {
    composable<Route.Storage> {
        StorageRoute(
            padding = padding,
            onNavigateToHome = onNavigateToHome
        )
    }
}
