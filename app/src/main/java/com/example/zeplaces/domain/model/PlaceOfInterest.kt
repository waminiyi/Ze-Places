package com.example.zeplaces.domain.model

/**
 * Represents a place of interest with various details such as name, rating, location, etc.
 * @property id The unique identifier of the place of interest.
 * @property name The name of the place of interest.
 * @property rating The rating of the place of interest.
 * @property ratingCount The count of ratings for the place of interest.
 * @property location The geographical coordinates of the place of interest.
 * @property isOpenNow Indicates whether the place of interest is open now.
 * @property photoReference The reference to a photo of the place of interest.
 * @property distance The distance between the user's location and the place of interest.
 * @property isFavorite Indicates whether the place of interest is marked as a favorite by the user.
 */
data class PlaceOfInterest(
    val id: String,
    val name: String,
    val rating: Float,
    val ratingCount: Int,
    val location: Coordinates,
    val isOpenNow: Boolean,
    val photoReference: String,
    val distance: Int,
    val isFavorite: Boolean = false
)
