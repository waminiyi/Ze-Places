package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoDto(
    @Json(name = "height") val height: Int,
    @Json(name = "html_attributions") val htmlAttributions: List<String>,
    @Json(name = "photo_reference") val photoReference: String,
    @Json(name = "width") val width: Int
)
