package com.example.taskplanner.data

import com.google.gson.annotations.SerializedName

data class RespuestaLoginDTO(
    @SerializedName("accessToken") var token:String?=null,
)