package com.waminiyi.zeplaces.data.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Class representing the Room database for saving places.
 *
 */
@Database(entities = [SavedPlaceEntity::class], version = 1, exportSchema = false)
abstract class RoomPlacesDatabase: RoomDatabase() {

    /**
     * The Data Access Object (DAO) for accessing saved places in the database.
     */
    abstract fun savedPlacesDao(): SavedPlacesDao
}
