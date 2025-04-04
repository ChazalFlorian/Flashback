package com.fchazal.signin.inject

import androidx.room.Room
import com.fchazal.signin.data.database.AppDatabase
import com.fchazal.signin.data.database.SessionRepositoryLocaleImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "credentials"
        ).build()
    }
    single {
        get<AppDatabase>().credentialsDAO()
    }
    singleOf(::SessionRepositoryLocaleImpl)
}