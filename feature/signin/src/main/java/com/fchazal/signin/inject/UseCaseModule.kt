package com.fchazal.signin.inject

import com.fchazal.signin.domain.interactor.SignInUseCase
import com.fchazal.signin.domain.interactor.SignInUseCaseImpl
import org.koin.dsl.module

val signInUseCaseModule = module {
    single<SignInUseCase> {
        SignInUseCaseImpl(
            signInRepository = get(),
            sessionRepository = get()
        )
    }
}