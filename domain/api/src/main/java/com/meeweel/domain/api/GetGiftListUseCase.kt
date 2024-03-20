package com.meeweel.domain.api

import com.meeweel.domain.models.Gift
import com.meeweel.domain.models.LoadResult

interface GetGiftListUseCase {

    suspend operator fun invoke(): LoadResult<List<Gift>>
}