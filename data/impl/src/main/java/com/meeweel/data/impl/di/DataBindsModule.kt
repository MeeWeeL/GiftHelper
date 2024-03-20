package com.meeweel.data.impl.di

import com.meeweel.data.api.GiftRepository
import com.meeweel.data.impl.GiftRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataBindsModule {

    @Binds
    fun bindGiftRepository(impl: GiftRepositoryImpl): GiftRepository
}