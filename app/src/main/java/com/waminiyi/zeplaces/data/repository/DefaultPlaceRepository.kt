package com.waminiyi.zeplaces.data.repository

import com.waminiyi.zeplaces.data.mappers.toPlaceOfInterest
import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import com.waminiyi.zeplaces.remote.datasource.RemoteDataSource

/**
 * Default implementation of the [PlacesRepository] interface.
 *
 */
class DefaultPlaceRepository(
    private val remoteDataSource: RemoteDataSource,
) : PlacesRepository {

    override suspend fun getNearbyPlaces(
        placeType: PlaceType,
        coordinates: Coordinates,
        radius: Int
    ): List<PlaceOfInterest> {

        return remoteDataSource.getNearbyPlaces(
            location = "${coordinates.latitude},${coordinates.longitude}",
            radius = radius,
            placeType = placeType.typeKey
        )?.map { it.toPlaceOfInterest() } ?: emptyList()
    }

}
