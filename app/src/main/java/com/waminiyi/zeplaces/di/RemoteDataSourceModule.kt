package com.waminiyi.zeplaces.di

import com.example.zeplaces.remote.api.PlaceApi
import com.waminiyi.zeplaces.remote.datasource.GoogleRemoteDataSource
import com.waminiyi.zeplaces.remote.datasource.RemoteDataSource
import org.koin.dsl.module

const val BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"


val remoteDatasourceModule = module {
    single {
        PlaceApi(
            baseUrl = BASE_URL,
            client = get()
        )
    }

    single<RemoteDataSource> {
        GoogleRemoteDataSource(
            placeApi = get()
        )
    }
}
