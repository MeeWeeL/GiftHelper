package com.meeweel.data.api

import com.meeweel.domain.models.Gift
import com.meeweel.domain.models.LoadResult

interface GiftRepository {

    suspend fun getGiftList(): LoadResult<List<Gift>>
}