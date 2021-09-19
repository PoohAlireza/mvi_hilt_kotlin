package com.alireza.testhilt2.retrofit

import com.alireza.testhilt2.retrofit.userNetworkEntity.UserNetworkEntity
import retrofit2.http.GET

interface UserRetrofit {

    @GET(value = "users")
    suspend fun getUsers():List<UserNetworkEntity>

}