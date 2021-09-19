package com.alireza.testhilt2.retrofit.userNetworkEntity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserNetworkEntity(

    @SerializedName(value = "id")
    @Expose
    var id:Int,

    @SerializedName(value = "name")
    @Expose
    var name:String,

    @SerializedName(value = "username")
    @Expose
    var username:String,

    @SerializedName(value = "phone")
    @Expose
    var phone:String,

    @SerializedName(value = "email")
    @Expose
    var email:String,

    @SerializedName(value = "website")
    @Expose
    var website:String,

    @SerializedName(value = "address")
    @Expose
    var addressNetworkEntity: AddressNetworkEntity,

    @SerializedName(value = "company")
    @Expose
    var companyNetworkEntity: CompanyNetworkEntity,


)
