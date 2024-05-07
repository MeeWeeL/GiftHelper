package com.meeweel.app_admin.data.impl

import com.meeweel.app_admin.data.impl.models.GiftResponse
import retrofit2.Response
import retrofit2.http.GET

interface GiftApi {

    @GET("gifthelper/admin/getGiftList")
    suspend fun getGiftList(): Response<List<GiftResponse>>
}