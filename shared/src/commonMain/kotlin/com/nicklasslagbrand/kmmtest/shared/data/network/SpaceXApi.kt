package com.nicklasslagbrand.kmmtest.shared.data.network

import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class SpaceXApi {
    private val httpClient =HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getAllRocketLaunches(): List<RocketLaunch> {
        return httpClient.get("$SPACEX_BASE_URL/launches")
    }
    companion object {
        private const val SPACEX_API_VERSION = "v3"
        private const val SPACEX_BASE_URL = "https://api.spacexdata.com/$SPACEX_API_VERSION"
    }
}