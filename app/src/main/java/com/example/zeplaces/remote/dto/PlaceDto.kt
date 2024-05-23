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
 * @property iconMaskBaseUri The base URI for the icon mask.
 * @property name The human-readable name of the place.
 * @property openingHours The opening hours information of the place, if available.
 * @property photos A list of photos associated with the place, if available.
 * @property placeId A unique identifier for the place.
 * @property priceLevel The price level of the place (e.g., 1-4).
 * @property rating The average rating of the place (e.g., 4.5).
 * @property types A list of types describing the place (e.g., ["bar", "restaurant"]).
 * @property userRatingsTotal The total number of user ratings for the place.
 * @property vicinity A feature name of a place.
 */
@Serializable
data class PlaceDto(
    @SerialName("business_status") val businessStatus: String,
    @SerialName("geometry") val geometry: GeometryDto,
    @SerialName("icon") val icon: String,
    @SerialName("icon_background_color") val iconBackgroundColor: String,
    @SerialName("icon_mask_base_uri") val iconMaskBaseUri: String,
    @SerialName("name") val name: String,
    @SerialName("opening_hours") val openingHours: OpeningHoursDto? = null,
    @SerialName("photos") val photos: List<PhotoDto>? = null,
    @SerialName("place_id") val placeId: String,
    @SerialName("price_level") val priceLevel: Int,
    @SerialName("rating") val rating: Float,
    @SerialName("types") val types: List<String>,
    @SerialName("user_ratings_total") val userRatingsTotal: Int,
    @SerialName("vicinity") val vicinity: String
)
