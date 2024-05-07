package com.meeweel.app_admin.data.impl

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
        val uri: URI = chain.request().url.toUri()
        var path: String = uri.path
        path = path.substringAfterLast('/')

        val query = uri.query

        val responseString: String? = getJsonDataFromAsset(
            context,
            fileName = query?.let {
                when (path) {
                    "getGiftList" -> "$path/getGiftList"
                    "sendGiftOffer" -> ""
                    else -> path
                }
            } ?: path
        )
        // Create the response
        val responseBuilder = Response.Builder()
            .code(HTTP_OK)
            .addHeader("content-type", "application/json")
            .message("mocked response")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
        responseString?.let {
            responseBuilder.body(it.toByteArray().toResponseBody("application/json".toMediaType()))
        } ?: responseBuilder.code(406).message("Mock messsage 406")

        return responseBuilder.build()
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        return try {
            context.assets.open("$fileName.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }
}