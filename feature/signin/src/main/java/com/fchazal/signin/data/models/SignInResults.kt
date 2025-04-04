package com.fchazal.signin.data.models

data class SignInResults(
    val email: String,
    val token: String,
    val error: List<String>?
)
