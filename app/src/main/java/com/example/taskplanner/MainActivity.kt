package com.example.taskplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskplanner.data.PostDTO
import com.example.taskplanner.data.UserDTO
import com.example.taskplanner.databinding.ActivityMainBinding
import com.example.taskplanner.service.Endpoints
import com.example.taskplanner.service.RetrofitGenerator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // binding.tv.text="hola world"

        val usuario = UserDTO("estiven@gmail.com","1234")
        val usuario2= UserDTO("santiago@mail.com","passw0rd")


        binding.postrecycler.layoutManager = LinearLayoutManager(this)
        val adapter = PostAdapter()



        val retrofit=RetrofitGenerator.getInstance()
        val endpoints = retrofit.create(Endpoints::class.java)
        binding.button.setOnClickListener {
            val intent = Intent(this@MainActivity, plantalla2::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)

        }






        GlobalScope.launch {
             val respuesta = endpoints.hacerLoging(usuario2)
            if(respuesta.isSuccessful){
                val token = respuesta.body()
                Log.d("respuesta","Response: $token")
            }else{
                println("error")
            }
        }

        /*GlobalScope.launch {
            val respuesta = endpoints.traerPost()
            if(respuesta.isSuccessful){
                val post = respuesta.body()
                Log.d("respuesta","Response: $post")
            }else{
                println("error")
            }
        }*/

        GlobalScope.launch {
            val respuesta = endpoints.traerPost()
            if(respuesta.isSuccessful) {


                val respuestalistas= respuesta.body()
                val listarecycler= respuestalistas?.map { dto ->
                    PostDTO(dto.id,dto.userId,dto.title,dto.body)
                }


                runOnUiThread {
                    adapter.submitList(listarecycler)
                    binding.postrecycler.adapter=adapter


                }
            }
            else{
                println("error")
            }
        }
    }
}