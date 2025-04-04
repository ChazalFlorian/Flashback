package com.fchazal.core.ui.splash

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fchazal.core.ui.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToApp: () -> Unit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.illustration_splash_screen)
    )
    val progress by animateLottieCompositionAsState(composition)

    LaunchedEffect(key1 = true) {
        delay(3000L)
        navigateToApp()
    }
    LottieAnimation(
        modifier = Modifier.background(Color(0xFF25C9B9)),
        composition = composition,
        progress = { progress },
    )
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(navigateToApp = {})
}