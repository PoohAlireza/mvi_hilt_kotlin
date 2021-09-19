package com.alireza.testhilt2.di

import android.content.Context
import androidx.room.Room
import com.alireza.testhilt2.room.Dao
import com.alireza.testhilt2.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context):UserDatabase{
        return Room.databaseBuilder(context,UserDatabase::class.java,UserDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDao(userDatabase: UserDatabase):Dao{
        return userDatabase.getDao()
    }

}