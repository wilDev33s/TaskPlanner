package com.example.taskplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskplanner.data.PostDTO
import com.example.taskplanner.data.UsuariosDTO
import com.example.taskplanner.databinding.ActivityMainBinding
import com.example.taskplanner.databinding.ActivityPlantalla2Binding
import com.example.taskplanner.service.Endpoints
import com.example.taskplanner.service.RetrofitGenerator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class plantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPlantalla2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usuarioRecycler.layoutManager = LinearLayoutManager(this)

        val userAdapter = UserAdapter()

        val retrofit = RetrofitGenerator.getInstance()
        val endpoints = retrofit.create(Endpoints::class.java)


        binding.bottonBackp2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)

        }



        GlobalScope.launch {
            val respuesta = endpoints.traerUsuarios()
            if (respuesta.isSuccessful) {


                val listResponse = respuesta.body()
                val listarecycler2 = listResponse?.map { udto ->
                    UsuariosDTO(udto.idUser, udto.nombre, udto.email, udto.telefono, udto.sitioweb)
                }


                runOnUiThread {
                    userAdapter.submitList(listarecycler2)
                    binding.usuarioRecycler.adapter = userAdapter


                }
            } else {
                println("error")
            }
        }


    }
}