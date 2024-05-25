package com.example.zeplaces

import android.app.Application
import com.example.zeplaces.di.datasourceModule
import com.example.zeplaces.di.networkModule
import io.ktor.http.ContentType
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