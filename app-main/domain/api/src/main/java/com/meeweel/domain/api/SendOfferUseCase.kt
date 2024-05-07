package com.meeweel.domain.api

import android.graphics.Bitmap
import com.meeweel.domain.models.LoadResult

interface SendOfferUseCase {

    suspend operator fun invoke(
        title: String,
        description: String,
        price: Int,
        ozonUrl: String?,
        image: Bitmap?,
    ): LoadResult<Unit>
}