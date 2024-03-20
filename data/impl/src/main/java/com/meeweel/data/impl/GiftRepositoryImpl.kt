package com.meeweel.data.impl

import com.meeweel.data.api.GiftRepository
import com.meeweel.data.impl.ResultMapper.toLoadResult
import com.meeweel.domain.models.Gift
import com.meeweel.domain.models.LoadResult
import javax.inject.Inject

class GiftRepositoryImpl @Inject constructor(
    private val api: GiftApi,
) : GiftRepository {

    override suspend fun getGiftList(): LoadResult<List<Gift>> {
        return api.getGiftList().toLoadResult()
    }
}