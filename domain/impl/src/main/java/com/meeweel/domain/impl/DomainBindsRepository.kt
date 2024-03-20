package com.meeweel.domain.impl

import com.meeweel.domain.api.GetGiftListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindsRepository {

    @Binds
    fun bindGetGiftListUseCase(impl: GetGiftListUseCaseImpl): GetGiftListUseCase
}