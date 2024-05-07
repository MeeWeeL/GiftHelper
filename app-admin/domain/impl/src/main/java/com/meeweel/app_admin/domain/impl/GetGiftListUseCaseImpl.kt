package com.meeweel.app_admin.domain.impl

import com.meeweel.app_admin.data.api.GiftRepository
import com.meeweel.app_admin.domain.api.GetGiftListUseCase
import com.meeweel.app_admin.domain.models.Gift
import com.meeweel.app_admin.domain.models.LoadResult
import javax.inject.Inject

class GetGiftListUseCaseImpl @Inject constructor(
    private val repository: GiftRepository,
) : GetGiftListUseCase {

    override suspend operator fun invoke(): LoadResult<List<Gift>> {
        return repository.getGiftList()
    }
}