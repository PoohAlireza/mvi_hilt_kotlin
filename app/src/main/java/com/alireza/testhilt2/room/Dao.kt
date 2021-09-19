package com.alireza.testhilt2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userCacheEntity: UserCacheEntity):Long

    @Query("SELECT * FROM users")
    suspend fun getUsers():List<UserCacheEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getSingleUser(id:Int):UserCacheEntity

}