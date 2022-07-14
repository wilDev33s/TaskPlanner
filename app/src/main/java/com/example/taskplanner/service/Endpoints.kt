package com.example.taskplanner.service

import com.example.taskplanner.data.PostDTO
import com.example.taskplanner.data.RespuestaLoginDTO
import com.example.taskplanner.data.UserDTO
import com.example.taskplanner.data.UsuariosDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoints {
    @POST("/auth")
    suspend fun hacerLoging(@Body usuario: UserDTO): Response<RespuestaLoginDTO>

    @GET("posts")
    suspend fun  traerPost():Response<List<PostDTO>>

    @GET("users")
    suspend fun  traerUsuarios():Response<List<UsuariosDTO>>
}