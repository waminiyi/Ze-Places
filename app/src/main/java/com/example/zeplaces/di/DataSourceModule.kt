package com.example.zeplaces.di

import com.example.zeplaces.remote.api.PlaceApi
import com.example.zeplaces.remote.datasource.GoogleRemoteDataSource
import com.example.zeplaces.remote.datasource.RemoteDataSource
import org.koin.dsl.module

const val baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"


val datasourceModule = module {
    single {
        PlaceApi(
            baseUrl = baseUrl,
            client = get()
        )
    }

    single<RemoteDataSource> {
        GoogleRemoteDataSource(
            placeApi = get()
        )
    }
}
