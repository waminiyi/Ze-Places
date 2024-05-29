package com.waminiyi.zeplaces

import android.app.Application
import com.waminiyi.zeplaces.di.cacheDatasourceModule
import com.waminiyi.zeplaces.di.remoteDatasourceModule
import com.waminiyi.zeplaces.di.networkModule
import com.waminiyi.zeplaces.di.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

@Suppress("UndocumentedPublicClass")

class ZeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ZeApp)
            modules(
                networkModule,
                remoteDatasourceModule,
                cacheDatasourceModule,
                repositoriesModule
            )
        }
    }
}
