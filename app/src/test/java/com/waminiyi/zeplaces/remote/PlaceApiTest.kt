package com.waminiyi.zeplaces.remote

import com.waminiyi.zeplaces.di.networkModule
import com.example.zeplaces.remote.api.PlaceApi
import com.example.zeplaces.remote.utils.MockWebServerDispatcher
import io.ktor.client.HttpClient
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.GlobalContext.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertNotNull

class PlaceApiTest : KoinTest {

    private val client: HttpClient by inject()
    private val server = MockWebServer()


    @Before
    fun setUp() {
        server.start()
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun testOkRequestResponseIsWellHandled(): Unit = runBlocking {
        startKoin {
            modules(networkModule)
        }
        server.dispatcher = MockWebServerDispatcher().RequestDispatcher()

        val baseUrl = server.url("maps/api/place/nearbysearch/json")

        val placeApi = PlaceApi(
            baseUrl = baseUrl.toString(),
            client = client
        )

        val response = placeApi.getNearbyPlaces("-33.8670522, 151.2100055", 1500, "restaurant")
        println(response)
        assertNotNull(response)
    }

    @Test
    fun testInvalidRequestResponseIsWellHandled(): Unit = runBlocking {
        startKoin {
            modules(networkModule)
        }
        server.dispatcher = MockWebServerDispatcher().InvalidRequestDispatcher()

        val baseUrl = server.url("maps/api/place/nearbysearch/json")

        val placeApi = PlaceApi(
            baseUrl = baseUrl.toString(),
            client = client
        )

        val response = placeApi.getNearbyPlaces("-33.8670522$*dk151.2100055", 1500, "restaurant")
        println(response)
        assertNotNull(response)
    }
}