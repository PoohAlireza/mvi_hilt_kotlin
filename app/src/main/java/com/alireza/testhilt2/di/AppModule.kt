package com.alireza.testhilt2.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @RealGson
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RealGson

}