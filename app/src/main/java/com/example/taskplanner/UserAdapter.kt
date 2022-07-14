package com.example.taskplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskplanner.data.PostDTO
import com.example.taskplanner.data.UsuariosDTO
import com.example.taskplanner.databinding.TargetaPostBinding
import com.example.taskplanner.databinding.TarjetaUsuariosBinding


class UserAdapter : ListAdapter<UsuariosDTO, UserAdapter.UsuarioViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<UsuariosDTO>() {
        override fun areItemsTheSame(oldItem: UsuariosDTO, newItem: UsuariosDTO): Boolean {
            return oldItem.idUser == newItem.idUser
        }

        override fun areContentsTheSame(oldItem: UsuariosDTO, newItem: UsuariosDTO): Boolean {
            return oldItem.idUser == newItem.idUser
        }

    }

    lateinit var onItemClickListener: (UsuariosDTO) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {

        val binding = TarjetaUsuariosBinding.inflate(LayoutInflater.from(parent.context))
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val post = getItem(position)

        holder.bind(post)

    }

    inner class UsuarioViewHolder(private val binding: TarjetaUsuariosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(usuario: UsuariosDTO) {
            binding.tvIduser.text = usuario.idUser.toString()
            binding.tvNombre.text = usuario.nombre.toString()
            binding.tvEmail.text = usuario.email.toString()
            binding.tvPhone.text = usuario.telefono.toString()
            binding.tvWebsite.text = usuario.sitioweb.toString()

            binding.executePendingBindings()
        }

    }

}


