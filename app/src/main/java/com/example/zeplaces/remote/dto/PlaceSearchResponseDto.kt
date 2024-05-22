package com.waminiyi.zeplaces.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data transfer object representing the response from a place search API.
 *
 * @property htmlAttributions Attributions about this listing which must be displayed to the user.
 * @property results The list of Place search results.
 * @property nextPageToken A token that can be used to request up to 20 additional results. This field will be null if
 * there are no further results. The maximum number of results that can be returned is 60.
 * Note: There is a short delay between when this response is issued, and when nextPageToken will become valid to execute.
 * @property status The status of the response.
 */
@JsonClass(generateAdapter = true)
data class PlaceSearchResponseDto(
    @Json(name = "html_attributions") val htmlAttributions: List<String>,
    @Json(name = "results") val results: List<PlaceDto>,
    @Json(name = "next_page_token") val nextPageToken: String? = null,
    @Json(name = "status") val status: String
)
