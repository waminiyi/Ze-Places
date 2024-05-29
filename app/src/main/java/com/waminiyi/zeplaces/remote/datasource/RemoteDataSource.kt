package com.waminiyi.zeplaces.remote.datasource

import com.waminiyi.zeplaces.remote.dto.PlaceDto

/**
 * Interface defining methods to retrieve various types of nearby places from a remote data source.
 */
interface RemoteDataSource {

    /**
     * Retrieves nearby places based on the provided location, radius, and type.
     *
     * @param location The location coordinates in the format "latitude,longitude".
     * @param radius The radius within which to search for nearby places, in meters.
     * @param placeType The type of place to search for, e.g., "restaurant", "bar", etc.
     * @return A list of [PlaceDto] objects representing the nearby places, or null if an error occurred.
     */
    suspend fun getNearbyPlaces(
        location: String,
        radius: Int,
        placeType: String
    ): List<PlaceDto>?

    /**
     * Requests more places based on the provided page number.
     *
     * @return A list of [PlaceDto] objects representing the requested page of places,
     * null if an error occurred or no more places.
     */
    suspend fun requestMorePlaces(): List<PlaceDto>?


}
