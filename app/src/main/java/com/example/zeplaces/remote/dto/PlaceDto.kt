package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

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
@JsonClass(generateAdapter = true)
data class PlaceDto(
    @Json(name = "business_status") val businessStatus: String,
    @Json(name = "geometry") val geometry: GeometryDto,
    @Json(name = "icon") val icon: String,
    @Json(name = "icon_background_color") val iconBackgroundColor: String,
    @Json(name = "icon_mask_base_uri") val iconMaskBaseUri: String,
    @Json(name = "name") val name: String,
    @Json(name = "opening_hours") val openingHours: OpeningHoursDto? = null,
    @Json(name = "photos") val photos: List<PhotoDto>? = null,
    @Json(name = "place_id") val placeId: String,
    @Json(name = "price_level") val priceLevel: Int,
    @Json(name = "rating") val rating: Float,
    @Json(name = "types") val types: List<String>,
    @Json(name = "user_ratings_total") val userRatingsTotal: Int,
    @Json(name = "vicinity") val vicinity: String
)
