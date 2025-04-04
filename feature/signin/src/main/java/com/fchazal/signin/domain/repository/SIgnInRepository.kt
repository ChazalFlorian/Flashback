package com.fchazal.signin.domain.repository

import com.fchazal.signin.data.models.SignInPayload
import com.fchazal.signin.data.models.SignInResults

interface SignInRepository {
    suspend fun submitCredential(credential: SignInPayload): SignInResults
}
