package com.example.firstgitproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstgitproject.databinding.ServersItemBinding

class ServersAdapter(private val data :ArrayList<ServersData>) :RecyclerView.Adapter<ServersAdapter.ServersViewHolder>() {

    inner class ServersViewHolder(private val binding :ServersItemBinding , context: Context) :RecyclerView.ViewHolder(binding.root) {

        fun bindData(position :Int) {

            binding.txtNameOfServer.text = data[position].nameServer
            binding.txtPortNumber.text = data[position].portServer

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServersViewHolder {
        val binding = ServersItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ServersViewHolder(binding , parent.context)
    }

    override fun onBindViewHolder(holder: ServersViewHolder, position: Int) {

        holder.bindData(position)

    }

    override fun getItemCount(): Int {

        return data.size

    }

}