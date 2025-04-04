package com.fchazal.signin.data.repository

import com.fchazal.signin.data.models.SignInPayload
import com.fchazal.signin.data.models.SignInResults
import com.fchazal.signin.domain.repository.SignInRepository

class SignInRepositoryImpl(

) : SignInRepository {
    override suspend fun submitCredential(credential: SignInPayload): SignInResults {
        TODO("Not yet implemented")
    }
}
