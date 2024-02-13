package org.ae.rickandmorthykm.core

import android.app.Application
import core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    appModule()
                )
            )
            androidContext(this@MainApplication)
            androidLogger()
        }
    }
}