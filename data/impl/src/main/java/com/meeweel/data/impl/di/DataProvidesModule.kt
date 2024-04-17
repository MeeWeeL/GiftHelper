package com.meeweel.data.impl.di

import android.content.Context
import com.meeweel.data.impl.GiftApi
import com.meeweel.data.impl.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataProvidesModule {

    @Singleton
    @Provides
    fun provideRetrofitFactory(
        @ApplicationContext
        context: Context,
    ): RetrofitFactory = RetrofitFactory(context)

    @Singleton
    @Provides
    fun provideGiftApi(
        retrofitFactory: RetrofitFactory,
    ): GiftApi = retrofitFactory.createApi(isMock = true)
}