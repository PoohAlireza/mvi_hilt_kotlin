package com.alireza.testhilt2.retrofit.userNetworkEntity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CompanyNetworkEntity(

    @SerializedName(value = "name")
    @Expose
    var name:String,

    @SerializedName(value = "catchPhrase")
    @Expose
    var catchPhrase:String,

    @SerializedName(value = "bs")
    @Expose
    var bs:String,


)
