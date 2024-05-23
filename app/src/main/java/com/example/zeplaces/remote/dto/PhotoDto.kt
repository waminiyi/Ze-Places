package com.waminiyi.zeplaces.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing a photo of a place.
 *
 * @property height The height of the photo in pixels.
 * @property width The width of the photo in pixels.
 * @property photoReference A reference identifier for the photo, used to retrieve the image.
 */
@Serializable
data class PhotoDto(
    @SerialName("height") val height: Int,
    @SerialName("width") val width: Int,
    @SerialName("photo_reference") val photoReference: String
)
