package com.fchazal.signin.inject

import com.fchazal.signin.data.database.SessionRepositoryLocaleImpl
import com.fchazal.signin.data.repository.SignInRepositoryImpl
import com.fchazal.signin.domain.repository.SessionRepository
import com.fchazal.signin.domain.repository.SignInRepository
import org.koin.dsl.module

val signInRepositoryModule = module {
    single<SessionRepository> {
        SessionRepositoryLocaleImpl(
            credentialsDAO = get()
        )
    }
    single<SignInRepository> {
        SignInRepositoryImpl(

        )
    }
}