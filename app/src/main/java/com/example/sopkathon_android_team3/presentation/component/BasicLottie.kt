package com.example.sopkathon_android_team3.presentation.component

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun BasicLottie(
    @RawRes crystalAnimation: Int,
    modifier: Modifier = Modifier
) {
    val lottieAnimatable = rememberLottieAnimatable()

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(crystalAnimation))
    var isPlaying by remember { mutableStateOf(true) }
    var isReplay by remember { mutableStateOf(false) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
        iterations = 1,
        speed = 1f,
        restartOnPlay = true
    )

    LaunchedEffect(composition) {
        lottieAnimatable.animate(
            composition = composition,
            initialProgress = 0f
        )
    }

    LaunchedEffect (crystalAnimation) {
        isPlaying = true
        if (progress == 1.0f) {
            isReplay = true
        }
    }


    Box(
        modifier = modifier
            .wrapContentSize()
    ) {

        LottieAnimation(
            composition = composition,
            progress = {
                if (progress == 1.0f) {
                    isPlaying = false
                }
                if (isReplay) {
                    isPlaying = true
                    isReplay = false
                }
                progress
            },
            contentScale = ContentScale.Fit
        )
    }
}

