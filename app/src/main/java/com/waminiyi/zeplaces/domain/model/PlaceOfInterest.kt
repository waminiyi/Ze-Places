package com.waminiyi.zeplaces.domain.model

/**
 * Represents a place of interest with various details such as name, rating, location, etc.
 * @property id The unique identifier of the place of interest.
 * @property name The name of the place of interest.
 * @property rating The rating of the place of interest.
 * @property ratingCount The count of ratings for the place of interest.
 * @property address The address of the place of interest.
 * @property isOpenNow Indicates whether the place of interest is open now.
 * @property photoUrl The reference to a photo of the place of interest.
 */
data class PlaceOfInterest(
    val id: String,
    val name: String?,
    val rating: Float?,
    val ratingCount: Int?,
    val address: Address,
    val isOpenNow: Boolean?,
    val photoUrl: String?,
)
