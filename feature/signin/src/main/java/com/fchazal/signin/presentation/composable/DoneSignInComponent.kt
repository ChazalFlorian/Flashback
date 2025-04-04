package com.fchazal.signin.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fchazal.feature.signin.R

@Composable
fun DoneSignIn() {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.illustration_done)
    )
    val progress by animateLottieCompositionAsState(composition)

    LottieAnimation(
        modifier = Modifier.background(Color(0xFF25C9B9)),
        composition = composition,
        progress = { progress },
    )
}

@Preview
@Composable
fun DoneSignInPreview() {
    DoneSignIn()
}
