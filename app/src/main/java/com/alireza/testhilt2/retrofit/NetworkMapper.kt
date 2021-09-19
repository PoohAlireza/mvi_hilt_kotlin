package com.alireza.testhilt2.retrofit

import com.alireza.testhilt2.model.Address
import com.alireza.testhilt2.model.Company
import com.alireza.testhilt2.model.Geo
import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.retrofit.userNetworkEntity.AddressNetworkEntity
import com.alireza.testhilt2.retrofit.userNetworkEntity.CompanyNetworkEntity
import com.alireza.testhilt2.retrofit.userNetworkEntity.GeoNetworkEntity
import com.alireza.testhilt2.retrofit.userNetworkEntity.UserNetworkEntity
import com.alireza.testhilt2.util.EntityMapper
import com.google.gson.Gson
import javax.inject.Inject

class NetworkMapper @Inject constructor() : EntityMapper<UserNetworkEntity,User> {


    override fun mapFromEntity(entity: UserNetworkEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            username = entity.username,
            email = entity.email,
            phone = entity.phone,
            website = entity.website,
            address = Address(
                street = entity.addressNetworkEntity.street,
                suite = entity.addressNetworkEntity.suite,
                city = entity.addressNetworkEntity.city,
                zipcode = entity.addressNetworkEntity.zipcode,
                geo = Geo(
                    lat = entity.addressNetworkEntity.geoNetworkEntity.lat,
                    lng = entity.addressNetworkEntity.geoNetworkEntity.lng)
            ),
            company = Company(
                name = entity.companyNetworkEntity.name,
                catchPhrase = entity.companyNetworkEntity.catchPhrase,
                bs = entity.companyNetworkEntity.bs
            )
        )
    }

    override fun mapToEntity(domainModel: User): UserNetworkEntity {
        return UserNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            username = domainModel.username,
            email = domainModel.email,
            phone = domainModel.phone,
            website = domainModel.website,
            addressNetworkEntity = AddressNetworkEntity(
                street = domainModel.address.street,
                suite = domainModel.address.suite,
                city = domainModel.address.city,
                zipcode = domainModel.address.zipcode,
                geoNetworkEntity = GeoNetworkEntity(
                    lat = domainModel.address.geo.lat,
                    lng = domainModel.address.geo.lng)
            ),
            companyNetworkEntity = CompanyNetworkEntity(
                name = domainModel.company.name,
                catchPhrase = domainModel.company.catchPhrase,
                bs = domainModel.company.bs
            )
        )
    }



    fun getListFromEntities(entities:List<UserNetworkEntity>):List<User>{
        return entities.map { mapFromEntity(it) }
    }

}