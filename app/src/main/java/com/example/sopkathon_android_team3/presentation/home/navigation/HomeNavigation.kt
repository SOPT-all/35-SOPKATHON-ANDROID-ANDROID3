package com.example.sopkathon_android_team3.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.sopkathon_android_team3.presentation.home.HomeRoute
import com.example.sopkathon_android_team3.presentation.model.Route

fun NavController.navigateHome() {
    navigate(route = Route.Home)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    onNavigateToStorage : () -> Unit
) {
    composable<Route.Home> {
        HomeRoute(
            padding = padding,
            onNavigateToStorage = onNavigateToStorage
        )
    }
}
