package com.fchazal.flashback

import android.app.Application
import com.fchazal.flashback.inject.applicationModule
import com.fchazal.flashback.inject.repositoryModule
import com.fchazal.flashback.inject.useCaseModule
import com.fchazal.flashback.inject.viewModelModule
import com.fchazal.signin.inject.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class FlashbackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FlashbackApplication)
            modules(
                applicationModule,
                databaseModule,
                viewModelModule,
                useCaseModule,
                repositoryModule
            )
        }
    }
}
