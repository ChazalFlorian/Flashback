package com.fchazal.signin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fchazal.signin.domain.interactor.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase,
    // private val syncUseCase: SyncUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<SignInState>(SignInState.Loading)
    val uiState: StateFlow<SignInState>
        get() = _uiState.asStateFlow()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value =
                SignInState.Success(signInUseCase.submitSignInCredentials(email, password).token)
        }
    }
}