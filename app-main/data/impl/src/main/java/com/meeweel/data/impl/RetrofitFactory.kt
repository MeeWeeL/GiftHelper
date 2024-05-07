package com.meeweel.data.impl

import android.content.Context
import com.meeweel.data.impl.BuildConfig.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory(private val context: Context) {

    inline fun <reified T> createApi(isMock: Boolean = false): T = createRetrofit(isMock).create(T::class.java)

    fun createRetrofit(isMock: Boolean): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        client(client(isMock))
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        addConverterFactory(MoshiConverterFactory.create(moshi))
    }.build()

    private fun client(isMock: Boolean): OkHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(25, TimeUnit.SECONDS)
        writeTimeout(15, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        if (isMock) addInterceptor(MockInterceptor(context))
    }.build()
}