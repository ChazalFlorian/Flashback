package com.fchazal.flashback.inject

import com.fchazal.signin.inject.signInViewModelModule
import org.koin.dsl.module

val viewModelModule = module {
    includes(
        signInViewModelModule
    )
}