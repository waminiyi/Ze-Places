package com.waminiyi.zeplaces.data.cache.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Data Access Object (DAO) for accessing saved places in the local Room database.
 *
 */
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
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlace(place: SavedPlaceEntity)

    /**
     * Remove a place from saved places.
     * @param placeId The id of the place to remove.
     */
    @Query("DELETE FROM saved_places WHERE id  = :placeId")
    suspend fun removeFromSavedPlaces(placeId: String)
}
