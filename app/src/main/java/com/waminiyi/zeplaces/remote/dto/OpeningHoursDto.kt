package com.waminiyi.zeplaces.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing the opening hours status of a place.
 *
 * @property openNow Indicates if the place is currently open.
 */
@Serializable
data class OpeningHoursDto(
    @SerialName("open_now") val openNow: Boolean
)
