package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data transfer object representing a geographical location with latitude and longitude.
 *
 * @property lat The latitude of the location.
 * @property lng The longitude of the location.
 */
@JsonClass(generateAdapter = true)
data class LocationDto(
    @Json(name = "lat") val lat: Double,
    @Json(name = "lng") val lng: Double
)

