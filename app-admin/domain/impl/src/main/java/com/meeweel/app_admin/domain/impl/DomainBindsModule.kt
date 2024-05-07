package com.meeweel.app_admin.domain.impl

import com.meeweel.app_admin.domain.api.GetGiftListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindsModule {

    @Binds
    fun bindGetGiftListUseCase(impl: GetGiftListUseCaseImpl): GetGiftListUseCase
}