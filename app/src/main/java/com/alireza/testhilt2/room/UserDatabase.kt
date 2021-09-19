package com.alireza.testhilt2.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserCacheEntity::class],version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getDao():Dao

    companion object{
        val DATABASE_NAME:String = "users_db"
    }


}