package com.waminiyi.zeplaces.data.repository

import com.waminiyi.zeplaces.data.cache.room.SavedPlacesDao
import com.waminiyi.zeplaces.data.mappers.toPlaceOfInterest
import com.waminiyi.zeplaces.data.mappers.toSavedPlaceEntity
import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import com.waminiyi.zeplaces.remote.datasource.RemoteDataSource

/**
 * Default implementation of the [PlacesRepository] interface.
 *
 * This repository class acts as a mediator between the remote data source ([RemoteDataSource])
 * and the local data source ([SavedPlacesDao]). It provides methods to retrieve various types
 * of nearby places, either from the remote data source or the local database.
 *
 * @param remoteDataSource The remote data source responsible for fetching places from an external API.
 * @param localDataSource The local data source providing access to saved places stored in a Room database.
 */
class DefaultPlaceRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: SavedPlacesDao
) : PlacesRepository {
    override suspend fun getSavedPlaces(): List<PlaceOfInterest> {
        return localDataSource.getAllSavedPlaces().map { it.toPlaceOfInterest() }
    }

    override suspend fun savePlace(place: PlaceOfInterest) {
        localDataSource.savePlace(place.toSavedPlaceEntity())
    }

    override suspend fun removeFromSavedPlace(placeId: String) {
        localDataSource.removeFromSavedPlaces(placeId)
    }

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

    override suspend fun requestMorePlaces(): List<PlaceOfInterest> {
        return remoteDataSource.requestMorePlaces()?.map { it.toPlaceOfInterest() } ?: emptyList()
    }
}
