package com.alireza.testhilt2.retrofit.userNetworkEntity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeoNetworkEntity(

    @SerializedName(value = "lat")
    @Expose
    var lat:String,

    @SerializedName(value = "lng")
    @Expose
    var lng:String

)
