package com.fchazal.signin.data.database

import com.fchazal.signin.data.models.SignInResults
import com.fchazal.signin.data.toEntity
import com.fchazal.signin.data.toSignInResults
import com.fchazal.signin.domain.repository.SessionRepository

class SessionRepositoryLocaleImpl(
    private val credentialsDAO: CredentialsDAO,
) : SessionRepository {
    override suspend fun addCredentials(credential: SignInResults) {
        credentialsDAO.insert(credential.toEntity())
    }

    override suspend fun getCredentials(email: String): SignInResults? {
        credentialsDAO.getCredentialsByEmail(email)?.let {
            return it.toSignInResults()
        }
        return null
    }

    override suspend fun updateToken(credential: SignInResults) {
        credentialsDAO.updateToken(credential.email, credential.token)
    }
}