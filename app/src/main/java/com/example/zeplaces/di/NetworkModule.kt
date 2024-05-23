package com.example.zeplaces.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import io.ktor.serialization.kotlinx.json.json

val networkModule =

    module {
        single<HttpClient> {
            HttpClient(Android) {
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = LogLevel.HEADERS
                }

                install(ContentNegotiation) {
                    json(
                        json =
                        Json {
                            ignoreUnknownKeys = true
                        }
                    )
                }

                install(DefaultRequest) {
                    headers.append("key", "API_KEY")
                }
            }
        }
    }