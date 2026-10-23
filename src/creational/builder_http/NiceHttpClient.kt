package creational.builder_http

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.Headers.Companion.toHeaders
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

class NiceHttpClient private constructor(
    private val baseUrl: String,
    private val cookie: Map<String, String>,
    private val headers: Map<String, String>,
    private val readTimeout: Long,
    private val writeTimeout: Long,
    private val cacheControl: CacheControl,
    private val connectionPool: ConnectionPool?,
    private val retryOnConnectionFailure: Boolean,
    private val retryLimit: Int?,
    connectionTimeout: Long,

    ) {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS)
        .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
        .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(retryOnConnectionFailure)
        .connectionPool(connectionPool ?: ConnectionPool())
        .build()

    suspend fun get(
        endpoint: String,
        queryParams: Map<String, String> = emptyMap(),
        customHeaders: Map<String, String> = emptyMap()
    ): Resource<Response> = executeRequest {
        buildRequest(endpoint, queryParams, customHeaders).get().build()
    }


    suspend fun postForm(
        endpoint: String,
        queryParams: Map<String, String> = emptyMap(),
        customHeaders: Map<String, String> = emptyMap(),
        formData: Map<String, String> = emptyMap(),
    ): Resource<Response> {
        val formBuilder = FormBody.Builder()
        formData.forEach { (key, value) -> formBuilder.add(key, value) }
        return post(endpoint, queryParams, customHeaders, formBuilder.build())
    }

    suspend fun post(
        endpoint: String,
        queryParams: Map<String, String> = emptyMap(),
        customHeaders: Map<String, String> = emptyMap(),
        body: RequestBody
    ): Resource<Response> = executeRequest {
        buildRequest(endpoint, queryParams, customHeaders).post(body).build()
    }

    private suspend fun executeRequest(requestBuilder: () -> Request): Resource<Response> =
        withContext(Dispatchers.IO) {
            val maxAttempts = if (retryOnConnectionFailure && (retryLimit ?: 0) > 0) retryLimit!! else 1

            var lastError: NiceHttpError = NiceHttpError.Unknown()

            for (attempt in 1..maxAttempts) {
                try {
                    val request = requestBuilder()
                    val response = client.newCall(request).execute()
                    if (response.isSuccessful) {
                        return@withContext Resource.Success(response)
                    }

                    lastError = NiceHttpError.ServerError(
                        code = response.code,
                        resBody = response.body.string(),
                        message = "Unexpected response code ${response.code} | ${response.message}"
                    )
                    response.close()

                } catch (e: NiceHttpError) {
                    lastError = e
                    break
                } catch (e: SocketTimeoutException) {
                    lastError = NiceHttpError.Timeout("Timeout error: ${e.message}", cause = e)
                } catch (e: IOException) {
                    lastError = NiceHttpError.Network("Network error: ${e.message}", cause = e)
                }

                if (attempt < maxAttempts) {
                    println("Attempt $attempt failed (${lastError.message}). Retrying...")
                    delay(1000.milliseconds)
                }
            }

            return@withContext Resource.Error(lastError)
        }

    private fun buildRequest(
        endpoint: String,
        queryParams: Map<String, String>,
        customHeaders: Map<String, String>
    ): Request.Builder {
        val cleanBase = baseUrl.trimEnd('/')
        val cleanEndpoint = endpoint.trimStart('/')
        val fullUrl = "$cleanBase/$cleanEndpoint"

        val urlBuilder =
            fullUrl.toHttpUrlOrNull()?.newBuilder() ?: throw NiceHttpError.InvalidUrl(fullUrl)
        queryParams.forEach { (k, v) -> urlBuilder.addQueryParameter(k, v) }

        val allHeaders = HashMap(headers).apply { putAll(customHeaders) }

        if (cookie.isNotEmpty()) {
            val cookieString = cookie.entries.joinToString("; ") { "${it.key}=${it.value}" }
            allHeaders["Cookie"] = cookieString
        }

        return Request.Builder().url(urlBuilder.build()).headers(allHeaders.toHeaders()).cacheControl(cacheControl)
    }

    class Builder(private val baseUrl: String) {
        private val cookie = HashMap<String, String>()
        private val headers = HashMap<String, String>()
        private var connectionTimeout: Long = 5000
        private var readTimeout: Long = 5000
        private var writeTimeout: Long = 5000
        private var cacheControl = CacheControl.Builder().maxAge(1, TimeUnit.MINUTES).build()
        private var connectionPool: ConnectionPool? = null
        private var retryOnConnectionFailure = true
        private var retryLimit: Int? = 4

        fun setRetryOnConnectionFailure(retryOnConnectionFailure: Boolean): Builder {
            this.retryOnConnectionFailure = retryOnConnectionFailure
            return this
        }

        fun setRetryLimit(retryLimit: Int): Builder {
            this.retryLimit = retryLimit
            return this
        }

        fun cookies(cookies: Map<String, String>): Builder {
            this.cookie.clear()
            this.cookie.putAll(cookies)
            return this
        }

        fun headers(headers: Map<String, String>): Builder {
            this.headers.clear()
            this.headers.putAll(headers)
            return this
        }

        fun addHeader(name: String, value: String): Builder {
            this.headers[name] = value
            return this
        }

        fun connectionTimeout(connectionTimeout: Long): Builder {
            this.connectionTimeout = connectionTimeout
            return this
        }

        fun readTimeout(readTimeout: Long): Builder {
            this.readTimeout = readTimeout
            return this
        }

        fun writeTimeout(writeTimeout: Long): Builder {
            this.writeTimeout = writeTimeout
            return this
        }

        fun connectionPool(connectionPool: ConnectionPool): Builder {
            this.connectionPool = connectionPool
            return this
        }

        fun cacheControl(cacheControl: CacheControl): Builder {
            this.cacheControl = cacheControl
            return this
        }

        fun build(): NiceHttpClient {
            return NiceHttpClient(
                baseUrl,
                cookie,
                headers,
                readTimeout,
                writeTimeout,
                cacheControl,
                connectionPool,
                retryOnConnectionFailure,
                retryLimit = retryLimit,
                connectionTimeout = connectionTimeout
            )
        }
    }
}