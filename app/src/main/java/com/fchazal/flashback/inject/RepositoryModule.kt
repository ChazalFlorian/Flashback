package com.fchazal.flashback.inject

import com.fchazal.signin.inject.signInRepositoryModule
import org.koin.dsl.module

val repositoryModule = module {
    includes(
        signInRepositoryModule
    )
}