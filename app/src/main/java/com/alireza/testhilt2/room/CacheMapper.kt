package com.alireza.testhilt2.room

import com.alireza.testhilt2.di.AppModule
import com.alireza.testhilt2.di.RetrofitModule
import com.alireza.testhilt2.model.Address
import com.alireza.testhilt2.model.Company
import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.util.EntityMapper
import com.google.gson.Gson
import java.util.*
import javax.inject.Inject


class CacheMapper @Inject constructor(@AppModule.RealGson val gson: Gson) : EntityMapper<UserCacheEntity,User> {


    override fun mapFromEntity(entity: UserCacheEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            username = entity.username,
            phone = entity.phone,
            website = entity.website,
            email = entity.email,
            address = gson.fromJson(entity.address,Address::class.java),
            company = gson.fromJson(entity.company,Company::class.java)
        )
    }

    override fun mapToEntity(domainModel: User): UserCacheEntity {
        return UserCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            username = domainModel.username,
            phone = domainModel.phone,
            email = domainModel.email,
            website = domainModel.website,
            address = gson.toJson(domainModel.address),
            company = gson.toJson(domainModel.company)
        )
    }

    fun getListFromEntities(entities:List<UserCacheEntity>):List<User>{
        return entities.map { mapFromEntity(it) }
    }

}