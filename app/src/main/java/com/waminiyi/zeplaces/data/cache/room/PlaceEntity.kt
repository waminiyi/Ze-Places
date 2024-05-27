package com.waminiyi.zeplaces.data.cache.room


data class PlaceEntity(
    val id: String,
    val name: String?,
    val rating: Float?,
    val ratingCount: Int?,
    val addressName: String?,
    val latitude: Double,
    val longitude: Double,
    val isOpenNow: Boolean?,
    val photoUrl: String?,
    val distance: Int?,
    val isFavorite: Boolean = false
)
