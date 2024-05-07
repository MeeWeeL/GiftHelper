package com.meeweel.data.api

import android.graphics.Bitmap
import com.meeweel.domain.models.Gift
import com.meeweel.domain.models.LoadResult

interface GiftRepository {

    suspend fun getGiftList(): LoadResult<List<Gift>>
    suspend fun sendOffer(
        title: String,
        description: String,
        price: Int,
        ozonUrl: String?,
        image: Bitmap?,
    ): LoadResult<Unit>
}