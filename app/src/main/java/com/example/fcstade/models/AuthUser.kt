package com.example.fcstade.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthUser {
    @SerializedName("username")
    @Expose
    var username:String?=null

    @SerializedName("password")
    @Expose
    var password:String?=null
}