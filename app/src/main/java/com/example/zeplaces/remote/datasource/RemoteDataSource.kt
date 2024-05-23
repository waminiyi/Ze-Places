package com.example.zeplaces.remote.datasource

import com.waminiyi.zeplaces.remote.dto.PlaceDto

/**
 * Interface defining methods to retrieve various types of nearby places from a remote data source.
 */
interface RemoteDataSource {

    /**
     * Retrieves a list of nearby groceries.
     *
     * @return A list of [PlaceDto] objects representing nearby groceries, or null if an error occurred.
     */
    suspend fun getNearbyGroceries(): List<PlaceDto>?

    /**
     * Retrieves a list of nearby restaurants.
     *
     * @return A list of [PlaceDto] objects representing nearby restaurants, or null if an error occurred.
     */
    suspend fun getNearbyRestaurants(): List<PlaceDto>?

    /**
     * Retrieves a list of nearby ATMs (Automated Teller Machines).
     *
     * @return A list of [PlaceDto] objects representing nearby ATMs, or null if an error occurred.
     */
    suspend fun getNearbyAtms(): List<PlaceDto>?

    /**
     * Retrieves a list of nearby gas stations.
     *
     * @return A list of [PlaceDto] objects representing nearby gas stations, or null if an error occurred.
     */
    suspend fun getNearbyGasStations(): List<PlaceDto>?

    /**
     * Retrieves a list of nearby bakeries.
     *
     * @return A list of [PlaceDto] objects representing nearby bakeries, or null if an error occurred.
     */
    suspend fun getNearbyBakeries(): List<PlaceDto>?

    /**
     * Retrieves a list of nearby hotels.
     *
     * @return A list of [PlaceDto] objects representing nearby hotels, or null if an error occurred.
     */
    suspend fun getNearbyHotels(): List<PlaceDto>?

    /**
     * Requests more places based on the provided page number.
     *
     * @param page The page number indicating which page of places to request.
     * @return A list of [PlaceDto] objects representing the requested page of places, or null if an error occurred.
     */
    suspend fun requestMorePlaces(page: Int): List<PlaceDto>?
}
