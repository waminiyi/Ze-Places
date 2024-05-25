package com.example.zeplaces

import com.example.zeplaces.di.networkModule
import com.example.zeplaces.remote.api.PlaceApi
import io.ktor.client.HttpClient
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Test
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertNotNull

class PlaceApiTest : KoinTest {

    val client: HttpClient by inject()

    @Test
    fun testGetNearbyPlaces(): Unit = runBlocking {
        startKoin {
            modules(networkModule)
        }

        val server = MockWebServer()
        server.enqueue(MockResponse().setBody(mockResponse))
        server.start()
        val baseUrl = server.url("maps/api/place/nearbysearch/json")

        val placeApi = PlaceApi(
            baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json",
            client = client
        )

        val response = placeApi.getNearbyPlaces("-33.8670522, 151.2100055", 1500, "restaurant")
        println(response)
        assertNotNull(response)
    }
}