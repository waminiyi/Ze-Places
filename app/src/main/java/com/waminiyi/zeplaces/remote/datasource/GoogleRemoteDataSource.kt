package com.waminiyi.zeplaces.remote.datasource

import android.util.Log
import com.example.zeplaces.remote.api.PlaceApi
import com.example.zeplaces.remote.dto.PlacesSearchStatus
import com.waminiyi.zeplaces.remote.dto.PlaceDto
import java.io.IOException

/**
 * Implementation of [RemoteDataSource] interface for fetching data from the Google Places API.
 *
 * @property placeApi The API client for interacting with Google Places API.
 */
class GoogleRemoteDataSource(private val placeApi: PlaceApi) : RemoteDataSource {
    private var nextPageToken: String? = null

    override suspend fun getNearbyPlaces(
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
        } catch (e: IOException) {
            Log.d("Place search status", "Network error: ${e.message}")
            null
        }
    }

    override suspend fun requestMorePlaces(): List<PlaceDto>? {
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
            } catch (e: IOException) {
                Log.d("Place search status", "Network error: ${e.message}")
                null
            }
        }
    }

}
