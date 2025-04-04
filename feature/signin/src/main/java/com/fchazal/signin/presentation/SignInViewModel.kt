package com.fchazal.signin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fchazal.signin.domain.interactor.SignInUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<SignInState>(SignInState.Unconnected)
    val uiState: StateFlow<SignInState>
        get() = _uiState.asStateFlow()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _uiState.emit(SignInState.Loading)
            delay(1000)
            val res =signInUseCase.submitSignInCredentials(
                email,
                password
            )
            _uiState.emit(
                SignInState.Success(
                    res.token
                )
            )
        }
    }
}
