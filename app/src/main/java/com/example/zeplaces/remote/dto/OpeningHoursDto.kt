package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data transfer object representing the opening hours status of a place.
 *
 * @property openNow Indicates if the place is currently open.
 */
@JsonClass(generateAdapter = true)
data class OpeningHoursDto(
    @Json(name = "open_now") val openNow: Boolean
)
