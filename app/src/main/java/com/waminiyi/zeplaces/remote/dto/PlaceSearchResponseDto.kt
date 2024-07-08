package com.waminiyi.zeplaces.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing the response from a place search API.
 *
 * @property results The list of Place search results.
 * @property nextPageToken A token that can be used to request up to 20 additional results.
 * This field will be null if there are no further results. The maximum number of results
 * that can be returned is 60. Note: There is a short delay between when this response is
 * issued, and when nextPageToken will become valid to execute.
 * @property status The status of the response.
 */
@Serializable
data class PlaceSearchResponseDto(
    @SerialName("html_attributions") val htmlAttributions: List<String>,
    @SerialName("results") val results: List<PlaceDto>,
    @SerialName("next_page_token") val nextPageToken: String? = null,
    @SerialName("status") val status: String
)
