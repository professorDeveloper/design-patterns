package creational.builder

import java.net.http.HttpClient

fun main(args: Array<String>) {
    val director = Director()
    director.setWebsite(SimpleWebsiteBuilder())
    val client = HttpClient.newBuilder()
        .build()
    val httpClient = HttpClient.newBuilder()
    httpClient.priority(0).build()


}