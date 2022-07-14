package com.example.taskplanner.data

import com.google.gson.annotations.SerializedName

class UsuariosDTO (
    @SerializedName("id") var idUser: Int?=null,
    @SerializedName("name") var nombre:String?=null,
    @SerializedName("email")var email:String?=null,
    @SerializedName("phone") var telefono:String?=null,
    @SerializedName("website") var sitioweb:String?=null,
        )