package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Viewport(
    @Json(name = "northeast") val northeast: LocationDto,
    @Json(name = "southwest") val southwest: LocationDto
)

