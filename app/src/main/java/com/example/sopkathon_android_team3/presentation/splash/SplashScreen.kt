package com.example.sopkathon_android_team3.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.presentation.component.BasicLottie
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashCompleted: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000) // 2초 후 전환
        onSplashCompleted() // 콜백 호출
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_background_no_shadow),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        BasicLottie(
            crystalAnimation = R.raw.splash
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        SplashScreen({})
    }
}
