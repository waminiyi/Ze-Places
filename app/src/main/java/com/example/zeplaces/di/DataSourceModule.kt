package com.example.zeplaces.di

import com.example.zeplaces.remote.api.PlaceApi
import com.example.zeplaces.remote.datasource.GoogleRemoteDataSource
import com.example.zeplaces.remote.datasource.RemoteDataSource
import org.koin.dsl.module

val datasourceModule = module {
    single {
        PlaceApi(
            baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json",
            client = get()
        )
    }

    single<RemoteDataSource> {
        GoogleRemoteDataSource(
            placeApi = get()
        )
    }
}

