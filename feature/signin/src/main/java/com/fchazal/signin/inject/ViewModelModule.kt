package com.fchazal.signin.inject

import com.fchazal.signin.presentation.SignInViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val signInViewModelModule = module {
    viewModel<SignInViewModel> {
        SignInViewModel(
            signInUseCase = get()
        )
    }
}