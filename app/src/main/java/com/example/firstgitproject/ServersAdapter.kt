package com.example.firstgitproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstgitproject.databinding.ServersItemBinding
import java.text.FieldPosition

class ServersAdapter(private val data: ArrayList<ServersData> , private val serverEvent :ServersEvent) :
    RecyclerView.Adapter<ServersAdapter.ServersViewHolder>() {

    inner class ServersViewHolder(private val binding: ServersItemBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(position: Int) {

            binding.txtNameOfServer.text = data[position].nameServer
            binding.txtPortNumber.text = data[position].portServer

            binding.imgDeleteServer.setOnClickListener {
                serverEvent.onClickDelete(data[adapterPosition] , adapterPosition)
            }

            binding.imgEditServer.setOnClickListener {
                serverEvent.onClickEdit(data[adapterPosition] , adapterPosition)
            }

            binding.imgShareServer.setOnClickListener {
                serverEvent.onClickShowDetails(data[adapterPosition] , adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServersViewHolder {
        val binding = ServersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServersViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ServersViewHolder, position: Int) {

        holder.bindData(position)

    }

    override fun getItemCount(): Int {

        return data.size

    }

    fun addServer(NewServer: ServersData) {

        data.add(0, NewServer)
        notifyItemInserted(0)

    }

    fun removeServer(oldServer :ServersData , oldPosition:Int) {

        data.remove(oldServer)
        notifyItemRemoved(oldPosition)

    }

    fun editServer(server: ServersData , position: Int) {

        data.set(position , server)
        notifyItemChanged(position)

    }

}

interface ServersEvent {

    fun onClickDelete(oldServer :ServersData , oldPosition: Int)
    fun onClickEdit(server :ServersData , currentPosition: Int)
    fun onClickShowDetails(server: ServersData , currentPosition: Int)

}