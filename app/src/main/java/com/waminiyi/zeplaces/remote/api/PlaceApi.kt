package com.waminiyi.zeplaces.remote.api

import com.waminiyi.zeplaces.BuildConfig
import com.waminiyi.zeplaces.remote.dto.PlaceSearchResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType

/**
 * A service class to interact with the Google Places API.
 *
 * @property baseUrl The base URL for the Google Places API.
 * @property client The HTTP client used to make requests.
 */
class PlaceApi(
    private val baseUrl: String,
    private val client: HttpClient
) {
    /**
     * Retrieves a list of nearby places based on the specified parameters.
     *
     * @param location The latitude and longitude around which to retrieve place information, in the format "lat,lng".
     * @param radius The distance (in meters) within which to return place results.
     * @param placeType The type of place to search for (e.g., "restaurant").
     * @return A [PlaceSearchResponseDto] containing the search results.
     */
    suspend fun getNearbyPlaces(
        location: String,
        radius: Int,
        placeType: String,
    ): PlaceSearchResponseDto {
        return client.get(baseUrl) {
            accept(ContentType.Application.Json)
            parameter(LOCATION_KEY_NAME, location)
            parameter(RADIUS_KEY_NAME, radius)
            parameter(TYPE_KEY_NAME, placeType)
            parameter(KEY, BuildConfig.MAPS_API_KEY)
        }.body()
    }

    /**
     * Retrieves the next set of place results using the provided next page token.
     *
     * @param nextPageToken A token to retrieve the next page of results.
     * @return A [PlaceSearchResponseDto] containing the next set of search results.
     */
    suspend fun getNextPage(nextPageToken: String): PlaceSearchResponseDto {
        return client.get(baseUrl) {
            parameter(PAGE_TOKEN_KEY_NAME, nextPageToken)
            parameter(KEY,  BuildConfig.MAPS_API_KEY)
        }.body()
    }

    companion object {
        private const val LOCATION_KEY_NAME = "location"
        private const val RADIUS_KEY_NAME = "radius"
        private const val TYPE_KEY_NAME = "type"
        private const val PAGE_TOKEN_KEY_NAME = "pagetoken"
        private const val KEY = "key"
    }
}
