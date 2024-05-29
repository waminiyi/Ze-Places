package com.waminiyi.zeplaces.data.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SavedPlaceEntity::class], version = 1, exportSchema = false)
abstract class RoomPlacesDatabase: RoomDatabase() {

    abstract fun savedPlacesDao(): SavedPlacesDao
}