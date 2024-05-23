package com.example.zeplaces.remote.datasource

import com.waminiyi.zeplaces.remote.dto.PlaceDto

/**
 * Interface defining methods to retrieve various types of nearby places from a remote data source.
 */
interface RemoteDataSource {

    /**
     * Retrieves a list of nearby groceries.
     *
     * @param location The location to search around.
     * @param radius The search radius in meters.
     * @return A list of [PlaceDto] objects representing nearby groceries, or null if an error occurred.
     */
    suspend fun getNearbyGroceries(location: String, radius: Int): List<PlaceDto>?

    /**
     * Retrieves a list of nearby restaurants.
     *
     * @param location The location to search around.
     * @param radius The search radius in meters.
     * @return A list of [PlaceDto] objects representing nearby restaurants, or null if an error occurred.
     */
    suspend fun getNearbyRestaurants(location: String, radius: Int): List<PlaceDto>?

    /**
     * Retrieves a list of nearby ATMs (Automated Teller Machines).
     *
     * @param location The location to search around.
     * @param radius The search radius in meters.
     * @return A list of [PlaceDto] objects representing nearby ATMs, or null if an error occurred.
     */
    suspend fun getNearbyAtms(location: String, radius: Int): List<PlaceDto>?

    /**
     * Retrieves a list of nearby gas stations.
     *
     * @param location The location to search around.
     * @param radius The search radius in meters.
     * @return A list of [PlaceDto] objects representing nearby gas stations, or null if an error occurred.
     */
    suspend fun getNearbyGasStations(location: String, radius: Int): List<PlaceDto>?

    /**
     * Retrieves a list of nearby bakeries.
     *
     * @param location The location to search around.
     * @param radius The search radius in meters.
     * @return A list of [PlaceDto] objects representing nearby bakeries, or null if an error occurred.
     */
    suspend fun getNearbyBakeries(location: String, radius: Int): List<PlaceDto>?

    /**
     * Retrieves a list of nearby hotels.
     *
     * @param location The location to search around.
     * @param radius The search radius in meters.
     * @return A list of [PlaceDto] objects representing nearby hotels, or null if an error occurred.
     */
    suspend fun getNearbyHotels(location: String, radius: Int): List<PlaceDto>?

    /**
     * Requests more places based on the provided page number.
     *
     * @param page The page number indicating which page of places to request.
     * @return A list of [PlaceDto] objects representing the requested page of places, or null if an error occurred.
     */
    suspend fun requestMorePlaces(page: Int): List<PlaceDto>?
}
