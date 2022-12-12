package com.example.firstgitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstgitproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    lateinit var serversAdapter :ServersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewServers()

    }

    fun recyclerViewServers() {

        val listOfServers = arrayListOf(

            ServersData("Server One" , "server.comome : 433") ,
            ServersData("#V2rayFree" , "190.33.80 : 23110") ,
            ServersData("@CryptoPlus.ir" , "tel.net : 80") ,
            ServersData("Server Two" , "server.comome : 21") ,
            ServersData("telyar" , "90.322.1 : 57309") ,
            ServersData("NeverMore" , "666.666.13 : 99") ,
            ServersData("Germany!>!" , "styli.xmas") ,
            ServersData("HPB" , "birthday.op : 34101") ,
            ServersData("@fakeMailChannel" , "fakeMail.org : 111") ,


            )

        serversAdapter = ServersAdapter(listOfServers)
        binding.recyclerServers.adapter = serversAdapter
        binding.recyclerServers.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)

    }

}