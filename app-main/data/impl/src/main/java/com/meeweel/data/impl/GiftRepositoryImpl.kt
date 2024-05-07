package com.meeweel.data.impl

import android.graphics.Bitmap
import com.meeweel.core.common.toBase64String
import com.meeweel.data.api.GiftRepository
import com.meeweel.data.impl.ResultMapper.map
import com.meeweel.data.impl.ResultMapper.toLoadResult
import com.meeweel.data.impl.models.GiftOfferRequest
import com.meeweel.domain.models.Gift
import com.meeweel.domain.models.LoadResult
import javax.inject.Inject

class GiftRepositoryImpl @Inject constructor(
    private val api: GiftApi,
) : GiftRepository {

    override suspend fun getGiftList(): LoadResult<List<Gift>> {
        return api.getGiftList().toLoadResult().map { toModel() }
    }

    override suspend fun sendOffer(
        title: String,
        description: String,
        price: Int,
        ozonUrl: String?,
        image: Bitmap?,
    ): LoadResult<Unit> {
        val imageBase64String = image?.toBase64String()
        val request = GiftOfferRequest(
            title = title,
            description = description,
            price = price,
            ozonUrl = ozonUrl,
            image = imageBase64String,
        )
        return api.sendGiftOffer(request).toLoadResult()
    }
}