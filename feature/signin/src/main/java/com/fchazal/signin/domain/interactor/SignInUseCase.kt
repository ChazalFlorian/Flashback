package com.fchazal.signin.domain.interactor

import com.fchazal.signin.data.models.SignInResults
import com.fchazal.signin.domain.repository.SessionRepository
import com.fchazal.signin.domain.repository.SignInRepository

interface SignInUseCase {
    suspend fun checkCurrentCredential(email: String?): SignInResults?
    suspend fun submitSignInCredentials(email: String, password: String): SignInResults
}

class SignInUseCaseImpl(
    private val signInRepository: SignInRepository,
    private val sessionRepository: SessionRepository,
) : SignInUseCase {

    override suspend fun checkCurrentCredential(email: String?): SignInResults? {
        email?.let {
            return sessionRepository.getCredentials(email)
        }
        return null
    }

    override suspend fun submitSignInCredentials(email: String, password: String): SignInResults {
        //this should ideally be sent to an endpoint
        // I wanted to setup a Mock API on Firebase to simulate an answer
        // by lack of time I didn't,
        //  so this just return success with dummy to see the whole User flow

        val credential = SignInResults(
            email = "john@doe.com",
            token = "dummy",
            error = null
        )
        sessionRepository.addCredentials(credential)
        return credential
    }
}