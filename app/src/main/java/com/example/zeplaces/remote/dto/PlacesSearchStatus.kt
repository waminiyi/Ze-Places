package com.example.zeplaces.remote.dto

/**
 * Status codes returned by service.
 */
sealed class PlacesSearchStatus(val statusCode: String) {
    /**
     * Indicates that the API request was successful.
     */
    data object OK : PlacesSearchStatus("OK")

    /**
     * Indicates that the search was successful but returned no results.
     * This may occur if the search was passed a latlng in a remote location.
     */
    data object ZERO_RESULTS : PlacesSearchStatus("ZERO_RESULTS")

    /**
     * Indicates that the API request was malformed, generally due to a missing required query parameter (location or radius).
     */
    data object INVALID_REQUEST : PlacesSearchStatus("INVALID_REQUEST")

    /**
     * Indicates that the request was denied due to exceeding query limits, billing issues, or other reasons.
     */
    data object OVER_QUERY_LIMIT : PlacesSearchStatus("OVER_QUERY_LIMIT")

    /**
     * Indicates that the request was denied due to missing or invalid API key.
     */
    data object REQUEST_DENIED : PlacesSearchStatus("REQUEST_DENIED")

    /**
     * Indicates an unknown error occurred.
     */
    data object UNKNOWN_ERROR : PlacesSearchStatus("UNKNOWN_ERROR")
}