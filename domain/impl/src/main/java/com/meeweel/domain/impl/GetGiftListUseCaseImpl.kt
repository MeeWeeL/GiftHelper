package com.meeweel.domain.impl

import com.meeweel.data.api.GiftRepository
import com.meeweel.domain.api.GetGiftListUseCase
import com.meeweel.domain.models.Gift
import com.meeweel.domain.models.LoadResult
import javax.inject.Inject

class GetGiftListUseCaseImpl @Inject constructor(
    private val repository: GiftRepository,
) : GetGiftListUseCase {

    override suspend operator fun invoke(): LoadResult<List<Gift>> {
        return repository.getGiftList()
    }
}