package com.alireza.testhilt2.model

import com.alireza.testhilt2.di.AppModule
import com.google.gson.Gson
import dagger.hilt.android.scopes.ServiceScoped
import dagger.hilt.internal.ComponentEntryPoint
import javax.inject.Inject


data class User constructor(

    var id:Int,
    var name:String,
    var username:String,
    var email:String,
    var phone:String,
    var website:String,
    var address: Address,
    var company: Company,

)
