package com.alireza.testhilt2.di

import com.alireza.testhilt2.repository.MainRepository
import com.alireza.testhilt2.retrofit.NetworkMapper
import com.alireza.testhilt2.retrofit.UserRetrofit
import com.alireza.testhilt2.room.CacheMapper
import com.alireza.testhilt2.room.Dao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        dao: Dao,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper,
        userRetrofit: UserRetrofit
    ):MainRepository{
        return MainRepository(dao, userRetrofit, cacheMapper, networkMapper)
    }

}