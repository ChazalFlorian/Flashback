package com.fchazal.flashback

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fchazal.core.ui.splash.SplashScreen
import com.fchazal.signin.presentation.SignInScreen
import com.fchazal.signin.presentation.SignInViewModel
import org.koin.java.KoinJavaComponent.inject

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
                SplashScreen(
                    navigateToApp = {
                        navController.navigate(FlashbackRoutes.SignIn.name)
                    }
                )
            }
            composable(route = FlashbackRoutes.SignIn.name) {
                val viewModel: SignInViewModel by inject(SignInViewModel::class.java)
                val state = remember { mutableStateOf(viewModel.uiState.value) }
                SignInScreen(
                    state = state.value,
                    onSignInClick = { email, password ->
                        viewModel.signIn(email, password)
                    }
                )
            }
            composable(route = FlashbackRoutes.Revive.name) {

            }
        }
    }
}