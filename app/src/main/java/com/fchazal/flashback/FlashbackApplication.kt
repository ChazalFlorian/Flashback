package com.fchazal.flashback

import android.app.Application
import com.fchazal.flashback.inject.applicationModule
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

            )
        }
    }
}
