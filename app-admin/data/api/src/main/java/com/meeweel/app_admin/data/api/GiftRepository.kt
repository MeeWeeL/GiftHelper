package com.meeweel.app_admin.data.api

import android.graphics.Bitmap
import com.meeweel.app_admin.domain.models.Gift
import com.meeweel.app_admin.domain.models.LoadResult

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