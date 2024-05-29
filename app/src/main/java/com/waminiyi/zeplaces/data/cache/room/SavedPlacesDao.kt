package com.waminiyi.zeplaces.data.cache.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SavedPlacesDao {
    /**
     * Retrieves the list of saved places .
     * @return A list of saved places.
     */
    @Query("SELECT * FROM saved_places")
    suspend fun getAllSavedPlaces(): List<SavedPlaceEntity>

    /**
     * Saves a place of interest.
     * @param place The place to save.
     */
    suspend fun savePlace(place: SavedPlaceEntity)

    /**
     * Remove a place from saved places.
     * @param place The place to remove.
     */
    suspend fun unSavePlace(place: SavedPlaceEntity)
}