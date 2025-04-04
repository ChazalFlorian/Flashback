package com.fchazal.flashback.inject

import com.fchazal.signin.inject.signInUseCaseModule
import org.koin.dsl.module

val useCaseModule = module {
    includes(
        signInUseCaseModule
    )
}