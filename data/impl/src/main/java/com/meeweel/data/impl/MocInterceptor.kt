package com.meeweel.data.impl

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.http.HTTP_OK
import java.io.IOException
import java.net.URI

internal class MockInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response?
        val uri: URI = chain.request().url.toUri()
        var path: String = uri.path
        path = path.substringAfterLast('/')

        val query = uri.query

        val responseString: String = getJsonDataFromAsset(
            context,
            fileName = query?.let {
                "$path/getGiftList"
            } ?: path
        ).orEmpty()
        // Create the response
        response = Response.Builder()
            .code(HTTP_OK)
            .message("mocked response")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .body(responseString.toByteArray().toResponseBody("application/json".toMediaType()))
            .addHeader("content-type", "application/json")
            .build()
        return response
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? =
        try {
            context.assets.open("$fileName.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
}