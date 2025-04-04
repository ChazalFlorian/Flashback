package com.fchazal.signin.domain.repository

import com.fchazal.signin.data.models.SignInResults

interface SessionRepository {
    suspend fun addCredentials(credential: SignInResults)
    suspend fun getCredentials(email: String): SignInResults?
    suspend fun updateToken(credential: SignInResults)
}