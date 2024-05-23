package com.example.zeplaces.remote.datasource

import android.util.Log
import com.example.zeplaces.remote.api.PlaceApi
import com.example.zeplaces.remote.dto.PlacesSearchStatus
import com.waminiyi.zeplaces.remote.dto.PlaceDto

class GoogleRemoteDataSource(private val placeApi: PlaceApi) : RemoteDataSource {
    private var nextPageToken: String? = null


    override suspend fun getNearbyGroceries(
        location: String,
        radius: Int
    ): List<PlaceDto>? = getNearbyPlaces(location, radius, GROCERIES)

    override suspend fun getNearbyRestaurants(
        location: String,
        radius: Int
    ): List<PlaceDto>? = getNearbyPlaces(location, radius, RESTAURANT)

    override suspend fun getNearbyAtms(
        location: String,
        radius: Int
    ): List<PlaceDto>? = getNearbyPlaces(location, radius, ATM)

    override suspend fun getNearbyGasStations(
        location: String,
        radius: Int
    ): List<PlaceDto>? = getNearbyPlaces(location, radius, GAS)

    override suspend fun getNearbyBakeries(
        location: String,
        radius: Int
    ): List<PlaceDto>? = getNearbyPlaces(location, radius, BAKERY)

    override suspend fun getNearbyHotels(
        location: String,
        radius: Int
    ): List<PlaceDto>? = getNearbyPlaces(location, radius, HOTELS)

    override suspend fun requestMorePlaces(page: Int): List<PlaceDto>? {
        return nextPageToken?.let {
            try {
                val response = placeApi.getNextPage(it)
                when (response.status) {
                    PlacesSearchStatus.OK.statusCode -> {
                        nextPageToken = response.nextPageToken
                        response.results
                    }

                    else -> {
                        Log.d("Place search status", response.status)
                        null
                    }
                }
            } catch (e: Exception) {
                Log.d("Place search status", e.message ?: "Unknown error")
                null
            }
        }
    }

    private suspend fun getNearbyPlaces(
        location: String,
        radius: Int,
        placeType: String
    ): List<PlaceDto>? {
        return try {
            val response = placeApi.getNearbyPlaces(
                location = location,
                radius = radius,
                placeType = placeType
            )
            when (response.status) {
                PlacesSearchStatus.OK.statusCode -> {
                    nextPageToken = response.nextPageToken
                    response.results
                }

                else -> {
                    Log.d("Place search status", response.status)
                    null
                }
            }
        } catch (e: Exception) {
            Log.d("Place search status", e.message ?: "Unknown error")
            null
        }
    }

    companion object {
        const val RESTAURANT = "restaurant"
        const val GROCERIES = "Groceries"
        const val ATM = "ATM"
        const val GAS = "Gas"
        const val BAKERY = "Bakery"
        const val HOTELS = "Hotels"
    }
}
