package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data transfer object representing the geometry of a place.
 *
 * @property location The geographical location of the place.
 */
@JsonClass(generateAdapter = true)
data class GeometryDto(
    @Json(name = "location") val location: LocationDto,
)
