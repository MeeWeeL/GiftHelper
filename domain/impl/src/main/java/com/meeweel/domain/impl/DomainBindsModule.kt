package com.meeweel.domain.impl

import com.meeweel.domain.api.GetGiftListUseCase
import com.meeweel.domain.api.SendOfferUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindsModule {

    @Binds
    fun bindGetGiftListUseCase(impl: GetGiftListUseCaseImpl): GetGiftListUseCase

    @Binds
    fun bindSendOfferUseCase(impl: SendOfferUseCaseImpl): SendOfferUseCase
}