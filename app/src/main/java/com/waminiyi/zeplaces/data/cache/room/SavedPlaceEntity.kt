package com.waminiyi.zeplaces.data.cache.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing a saved place in the database.
 *
 * @param id The unique identifier of the place.
 * @param name The name of the place.
 * @param rating The rating of the place.
 * @param ratingCount The total number of ratings for the place.
 * @param addressName The formatted address of the place.
 * @param latitude The latitude coordinate of the place's location.
 * @param longitude The longitude coordinate of the place's location.
 * @param isOpenNow Indicates whether the place is currently open.
 * @param photoUrl The URL of the photo associated with the place.
 * @param isSaved Indicates whether the place has been saved by the user.
 */
@Entity(tableName = "saved_places")

data class SavedPlaceEntity(
    @PrimaryKey
    val id: String,
    val name: String?,
    val rating: Float?,
    val ratingCount: Int?,
    val addressName: String?,
    val latitude: Double?,
    val longitude: Double?,
    val isOpenNow: Boolean?,
    val photoUrl: String?,
    val isSaved: Boolean = false
)
