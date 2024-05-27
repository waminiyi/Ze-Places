package com.waminiyi.zeplaces

import android.app.Application
import com.waminiyi.zeplaces.di.datasourceModule
import com.waminiyi.zeplaces.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ZeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ZeApp)
            modules(networkModule, datasourceModule)
        }
    }
}