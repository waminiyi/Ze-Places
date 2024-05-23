package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data transfer object representing a photo of a place.
 *
 * @property height The height of the photo in pixels.
 * @property width The width of the photo in pixels.
 * @property photoReference A reference identifier for the photo, used to retrieve the image.
 */
@JsonClass(generateAdapter = true)
data class PhotoDto(
    @Json(name = "height") val height: Int,
    @Json(name = "width") val width: Int,
    @Json(name = "photo_reference") val photoReference: String
)
