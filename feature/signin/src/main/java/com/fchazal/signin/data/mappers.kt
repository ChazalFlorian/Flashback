package com.fchazal.signin.data

import com.fchazal.signin.data.database.entity.CredentialEntity
import com.fchazal.signin.data.models.SignInResults

fun SignInResults.toEntity(): CredentialEntity = CredentialEntity(
    email = this.email,
    token = this.token ?: ""
)

fun CredentialEntity.toSignInResults(): SignInResults = SignInResults(
    email = this.email,
    token = this.token,
    error = null
)