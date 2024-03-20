package com.meeweel.data.impl

import com.meeweel.domain.models.Gift
import retrofit2.Response
import retrofit2.http.GET

interface GiftApi {

    @GET("/api/getGiftList")
    suspend fun getGiftList(): Response<List<Gift>>
}