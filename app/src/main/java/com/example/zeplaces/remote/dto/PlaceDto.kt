package com.waminiyi.zeplaces.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing a place with various attributes.
 *
 * @property businessStatus The operational status of the business (e.g., "OPERATIONAL").
 * @property geometry The geographical information about the place, including location.
 * @property icon The URL of the icon representing the place.
 * @property iconBackgroundColor The background color of the icon.
 * @property name The human-readable name of the place.
 * @property openingHours The opening hours information of the place, if available.
 * @property photos A list of photos associated with the place, if available.
 * @property placeId A unique identifier for the place.
 * @property rating The average rating of the place (e.g., 4.5).
 * @property types A list of types describing the place (e.g., ["bar", "restaurant"]).
 * @property userRatingsTotal The total number of user ratings for the place.
 * @property vicinity A feature name of a place.
 */
@Serializable
data class PlaceDto(
    @SerialName("business_status") val businessStatus: String? = null,
    @SerialName("geometry") val geometry: GeometryDto? = null,
    @SerialName("icon") val icon: String? = null,
    @SerialName("icon_background_color") val iconBackgroundColor: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("opening_hours") val openingHours: OpeningHoursDto? = null,
    @SerialName("photos") val photos: List<PhotoDto>? = null,
    @SerialName("place_id") val placeId: String? = null,
    @SerialName("rating") val rating: Float? = null,
    @SerialName("types") val types: List<String>? = null,
    @SerialName("user_ratings_total") val userRatingsTotal: Int? = null,
    @SerialName("vicinity") val vicinity: String? = null
)
