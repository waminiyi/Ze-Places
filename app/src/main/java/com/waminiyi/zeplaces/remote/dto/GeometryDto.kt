package com.waminiyi.zeplaces.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing the geometry of a place.
 *
 * @property location The geographical location of the place.
 */
@Serializable
data class GeometryDto(
    @SerialName("location") val location: LocationDto
)