package com.example.sopkathon_android_team3.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sopkathon_android_team3.presentation.home.navigation.homeNavGraph
import com.example.sopkathon_android_team3.presentation.home.navigation.navigateHome
import com.example.sopkathon_android_team3.presentation.model.Route
import com.example.sopkathon_android_team3.presentation.storage.navigation.navigateStorage
import com.example.sopkathon_android_team3.presentation.storage.navigation.storageNavGraph
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import com.example.sopkathon_android_team3.ui.theme.SopkathonAndroidTeam3Theme

@Composable
fun MainScreen(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MainNavHost(
            padding = innerPadding,
            navController = navController
        )
    }
}

@Composable
private fun MainNavHost(
    padding: PaddingValues,
    navController: NavHostController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SopkathonAndroidTeam3Theme.colors.black)
    ) {
        NavHost(
            navController = navController,
            startDestination = Route.Home,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            homeNavGraph(
                padding = padding,
                onNavigateToStorage = navController::navigateStorage
            )
            storageNavGraph(
                padding = padding,
                onNavigateToHome = navController::navigateHome
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        MainScreen(
            navController = rememberNavController()
        )
    }
}
