package com.waminiyi.zeplaces.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Data transfer object representing a geographical location with latitude and longitude.
 *
 * @property lat The latitude of the location.
 * @property lng The longitude of the location.
 */
@Serializable
data class LocationDto(
    @SerialName("lat") val lat: Double,
    @SerialName("lng") val lng: Double
)

