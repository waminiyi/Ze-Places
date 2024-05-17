package com.example.zeplaces.domain.repositories

import com.example.zeplaces.domain.model.PlaceOfInterest
import com.example.zeplaces.domain.model.PlaceType

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
     * Un-saves a place of interest.
     * @param place The place of interest to un-save.
     */
    suspend fun unSavePlace(place: PlaceOfInterest)

    /**
     * Checks if a place of interest is saved.
     * @param placeId The ID of the place of interest to check.
     * @return True if the place of interest is saved, false otherwise.
     */
    suspend fun checkIsSaved(placeId: String): Boolean

    /**
     * Retrieves nearby places of interest based on the specified place type.
     * @param placeType The type of place to search for.
     * @return A list of nearby places of interest.
     */
    suspend fun getNearbyPlaces(placeType: PlaceType): List<PlaceOfInterest>

    /**
     * Requests more places of interest.
     * @param page The page number of places to request.
     * @return A list of requested places of interest.
     */
    suspend fun requestMorePlaces(page: Int): List<PlaceOfInterest>
}

