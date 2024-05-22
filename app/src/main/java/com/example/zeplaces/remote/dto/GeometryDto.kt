package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeometryDto(
    @Json(name = "location") val location: LocationDto,
    @Json(name = "viewport") val viewport: Viewport
)
