package com.meeweel.data.impl

import com.meeweel.data.impl.models.GiftOfferRequest
import com.meeweel.domain.models.Gift
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GiftApi {

    @GET("giftHelper/api/getGiftList")
    suspend fun getGiftList(): Response<List<Gift>>

    @POST("giftHelper/api/sendGiftOffer")
    suspend fun sendGiftOffer(@Body giftOffer: GiftOfferRequest): Response<Unit>
}