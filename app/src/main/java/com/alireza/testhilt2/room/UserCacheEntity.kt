package com.alireza.testhilt2.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "username")
    var username:String,

    @ColumnInfo(name = "phone")
    var phone:String,

    @ColumnInfo(name = "email")
    var email:String,

    @ColumnInfo(name = "website")
    var website:String,

    @ColumnInfo(name = "address")
    var address:String,

    @ColumnInfo(name = "company")
    var company:String

)
