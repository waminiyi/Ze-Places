package com.waminiyi.zeplaces.domain.repositories

import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType

/**
 * Interface representing a repository for managing places of interest.
 */
interface PlacesRepository {

    /**
     * Retrieves the list of saved places of interest.
     * @return A list of saved places of interest.
     */
    suspend fun getSavedPlaces(): List<PlaceOfInterest>

    /**
     * Saves a place of interest.
     * @param place The place of interest to save.
     */
    suspend fun savePlace(place: PlaceOfInterest)

    /**
     * Remove a place of interest from the saved.
     * @param placeId The id of the place to remove.
     */
    suspend fun removeFromSavedPlace(placeId: String)

    /**
     * Retrieves nearby places of interest based on the specified place type.
     * @param placeType The type of place to search for.
     * @return A list of nearby places of interest.
     */
    suspend fun getNearbyPlaces(
        placeType: PlaceType,
        coordinates: Coordinates,
        radius: Int
    ): List<PlaceOfInterest>

    /**
     * Requests more places of interest.
     * @return A list of requested places of interest.
     */
    suspend fun requestMorePlaces(): List<PlaceOfInterest>
}

