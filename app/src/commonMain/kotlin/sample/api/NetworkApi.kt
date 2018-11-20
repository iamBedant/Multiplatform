package sample.api

import io.ktor.client.HttpClient
import io.ktor.client.features.ExpectSuccess
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import sample.AllData

/**
 * Created by @iamBedant on 13/11/18.
 */
class NetworkApi(private val endPoint: String) {

    private val httpClient = HttpClient {
        install(JsonFeature){
            serializer = KotlinxSerializer().apply {
                setMapper(AllData::class, AllData.serializer())
            }
        }
        install(ExpectSuccess)
    }

    suspend fun getAll(userId: String): AllData = httpClient.get {
        url {
            protocol = URLProtocol.HTTPS
            host = "api.github.com"
            encodedPath = "users/$userId"
        }
    }


    private fun HttpRequestBuilder.json() {
        contentType(ContentType.Application.Json)
    }


    private fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom(endPoint)
            encodedPath = path
        }
    }
}