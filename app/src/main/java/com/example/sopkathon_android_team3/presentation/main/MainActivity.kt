package com.example.sopkathon_android_team3.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.sopkathon_android_team3.presentation.splash.SplashScreen
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var showSplash by remember { mutableStateOf(true) }

            SOPKATHON_ANDROID_TEAM3Theme {
                if (showSplash) {
                    SplashScreen {
                        showSplash = false
                    }
                } else {
                    MainScreen(navController = navController)
                }
            }
        }
    }
}
