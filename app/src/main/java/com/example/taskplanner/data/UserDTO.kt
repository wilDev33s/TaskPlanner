package com.example.taskplanner.data

import com.google.gson.annotations.SerializedName

data class UserDTO (
    @SerializedName("email") var email:String?=null,
    @SerializedName("password") var password:String?=null,
)