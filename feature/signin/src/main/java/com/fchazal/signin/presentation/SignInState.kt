package com.fchazal.signin.presentation

sealed class SignInState {
    data object Loading: SignInState()
    data object Unconnected: SignInState()
    data class Success(val token: String): SignInState()
    data class Error(val error: String): SignInState()
}
