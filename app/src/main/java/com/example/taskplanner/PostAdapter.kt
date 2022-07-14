package com.example.taskplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskplanner.data.PostDTO
import com.example.taskplanner.databinding.TargetaPostBinding


private val TAG= PostAdapter::class.java.simpleName

class PostAdapter : ListAdapter<PostDTO, PostAdapter.EqViewHolder>(DiffCallback) {


        companion object DiffCallback: DiffUtil.ItemCallback<PostDTO>(){
            override fun areItemsTheSame(oldItem: PostDTO, newItem: PostDTO): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: PostDTO, newItem: PostDTO): Boolean {
                return oldItem == newItem
            }

        }

        lateinit var onItemClickListener:(PostDTO) -> Unit

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqViewHolder {

            val binding = TargetaPostBinding.inflate(LayoutInflater.from(parent.context))
            return  EqViewHolder(binding)
        }

        override fun onBindViewHolder(holder: EqViewHolder, position: Int) {
            val post = getItem(position)

            holder.bind(post)

        }

        inner class EqViewHolder(private val binding: TargetaPostBinding):
            RecyclerView.ViewHolder(binding.root){

            fun bind(postDTO: PostDTO){
                binding.tvTitleuserid.text= postDTO.userId.toString()
                binding.tvId.text = postDTO.id.toString()
                binding.tvTitle.text = postDTO.title.toString()
                binding.tvBody.text =postDTO.body.toString()

                binding.executePendingBindings()
            }

        }

    }

