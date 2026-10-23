package creational.builder_http

import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Response
import java.awt.PageAttributes

fun main() {
    runBlocking {
        val niceHttpClient = NiceHttpClient.Builder(baseUrl = "https://apisozo.azamov.me/").build()
        val response = niceHttpClient.get("api/contents/providers/qq")
        when (response) {
            is Resource.Error -> {
                println("Error ${response.throwable.resBody} | Body:${response.throwable.resBody} ")
            }

            is Resource.Success<Response> -> {
                println("Success ${response.data.body.string()}")
            }
        }
    }
}
