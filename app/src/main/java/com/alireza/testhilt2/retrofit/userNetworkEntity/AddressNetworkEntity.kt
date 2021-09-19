package com.alireza.testhilt2.retrofit.userNetworkEntity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddressNetworkEntity(

    @SerializedName(value = "street")
    @Expose
    var street:String,

    @SerializedName(value = "suite")
    @Expose
    var suite:String,

    @SerializedName(value = "city")
    @Expose
    var city:String,

    @SerializedName(value = "zipcode")
    @Expose
    var zipcode:String,

    @SerializedName(value = "geo")
    @Expose
    var geoNetworkEntity: GeoNetworkEntity

)
