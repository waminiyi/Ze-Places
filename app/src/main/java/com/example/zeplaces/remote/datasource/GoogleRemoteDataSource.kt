package com.example.zeplaces.remote.datasource

import com.example.zeplaces.remote.api.PlaceApi
import com.waminiyi.zeplaces.remote.dto.PlaceDto

class GoogleRemoteDataSource(private val placeApi: PlaceApi): RemoteDataSource {
    override suspend fun getNearbyGroceries(): List<PlaceDto>? {
        TODO("Not yet implemented")
    }

    override suspend fun getNearbyRestaurants(): List<PlaceDto>? {
        TODO("Not yet implemented")
    }

    override suspend fun getNearbyAtms(): List<PlaceDto>? {
        TODO("Not yet implemented")
    }

    override suspend fun getNearbyGasStations(): List<PlaceDto>? {
        TODO("Not yet implemented")
    }

    override suspend fun getNearbyBakeries(): List<PlaceDto>? {
        TODO("Not yet implemented")
    }

    override suspend fun getNearbyHotels(): List<PlaceDto>? {
        TODO("Not yet implemented")
    }

    override suspend fun requestMorePlaces(page: Int): List<PlaceDto>? {
        TODO("Not yet implemented")
    }
}