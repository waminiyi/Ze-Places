package com.waminiyi.zeplaces.di

import com.waminiyi.zeplaces.data.repository.DefaultPlaceRepository
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<PlacesRepository> {
        DefaultPlaceRepository(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }
}
