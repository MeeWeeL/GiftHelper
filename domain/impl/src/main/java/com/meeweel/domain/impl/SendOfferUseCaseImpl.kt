package com.meeweel.domain.impl

import android.graphics.Bitmap
import com.meeweel.data.api.GiftRepository
import com.meeweel.domain.api.SendOfferUseCase
import com.meeweel.domain.models.LoadResult
import javax.inject.Inject

class SendOfferUseCaseImpl @Inject constructor(
    private val giftRepository: GiftRepository,
): SendOfferUseCase {

    override suspend fun invoke(
        title: String,
        description: String,
        price: Int,
        ozonUrl: String?,
        image: Bitmap?,
    ): LoadResult<Unit> {
        return giftRepository.sendOffer(
            title,
            description,
            price,
            ozonUrl,
        image
            )
    }
}