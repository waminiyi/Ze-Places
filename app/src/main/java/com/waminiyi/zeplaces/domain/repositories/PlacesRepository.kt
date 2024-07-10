package com.waminiyi.zeplaces.domain.repositories

import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType

/**
 * Interface representing a repository for managing places of interest.
 */
interface PlacesRepository {

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
}

