package com.waminiyi.zeplaces.data.cache.room

import androidx.room.Entity
import androidx.room.PrimaryKey


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
