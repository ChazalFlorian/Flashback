package com.fchazal.flashback.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fchazal.flashback.FlashbackRoutes
import com.fchazal.flashback.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.illustration_splash_screen))
    val progress by animateLottieCompositionAsState(composition)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate(FlashbackRoutes.SignIn.name)
    }
    LottieAnimation(
        composition = composition,
        progress = { progress },
    )
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}