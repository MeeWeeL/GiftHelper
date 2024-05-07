package com.meeweel.app_admin.data.impl.di

import com.meeweel.app_admin.data.api.GiftRepository
import com.meeweel.app_admin.data.impl.GiftRepositoryImpl
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