package com.meeweel.app_admin.domain.api

import com.meeweel.app_admin.domain.models.Gift
import com.meeweel.app_admin.domain.models.LoadResult

interface GetGiftListUseCase {

    suspend operator fun invoke(): LoadResult<List<Gift>>
}