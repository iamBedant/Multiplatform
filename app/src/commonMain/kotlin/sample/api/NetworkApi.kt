package sample.api

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.takeFrom

/**
 * Created by @iamBedant on 13/11/18.
 */
class NetworkApi(private val endPoint: String) {

    private val client = HttpClient()


    suspend fun getAll(userId: String): String = client.get {
        url {
            protocol = URLProtocol.HTTPS
            host = "api.github.com"
            encodedPath = "users/iamBedant"
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