package com.fchazal.flashback

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fchazal.flashback.ui.SplashScreen

@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = FlashbackRoutes.Splash.name,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(route = FlashbackRoutes.Splash.name) {
                SplashScreen(navController)
            }
            composable(route = FlashbackRoutes.SignIn.name) {

            }
            composable(route = FlashbackRoutes.Library.name) {

            }
            composable(route = FlashbackRoutes.Revive.name) {

            }
        }
    }
}