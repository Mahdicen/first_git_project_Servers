package com.example.firstgitproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstgitproject.databinding.ActivityMainBinding
import com.example.firstgitproject.databinding.DialogAddServerBinding
import com.example.firstgitproject.databinding.DialogEditServerBinding

const val ABOUT_US_KEY = "AboutKey"
class MainActivity : AppCompatActivity(), ServersEvent {
    lateinit var binding: ActivityMainBinding
    lateinit var serversAdapter: ServersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewServers()

        binding.imgMenu.setOnClickListener {

            val dialogMenu = DialogFragmentMenuList()
            dialogMenu.show(supportFragmentManager , null)

        }

    }

    fun recyclerViewServers() {

        val listOfServers = arrayListOf(

            ServersData("Server One", "server.comome : 433"),
            ServersData("#V2rayFree", "190.33.80 : 23110"),
            ServersData("@CryptoPlus.ir", "tel.net : 80"),
            ServersData("Server Two", "server.comome : 21"),
            ServersData("telyar", "90.322.1 : 57309"),
            ServersData("NeverMore", "666.666.13 : 99"),
            ServersData("Germany!>!", "styli.xmas"),
            ServersData("HPB", "birthday.op : 34101"),
            ServersData("@fakeMailChannel", "fakeMail.org : 111"),


            )

        serversAdapter = ServersAdapter(listOfServers , this)
        binding.recyclerServers.adapter = serversAdapter
        binding.recyclerServers.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        binding.imgAddServer.setOnClickListener {

            val dialog = AlertDialog.Builder(this).create()
            val dialogBinding = DialogAddServerBinding.inflate(layoutInflater)
            dialog.setView(dialogBinding.root)
            dialog.show()

            val listOfPort = listOf(

                "110.20 : 433",
                "12.10.11 : 2011",
                "168.190.1.1 : 1128",
                "serversTel.rip : 80"

            )
            val adapterMenu = ArrayAdapter(this, R.layout.view_drop_down, listOfPort)
            (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).setAdapter(
                adapterMenu
            )

            dialogBinding.btnDoneServer.setOnClickListener {

                if (
                    dialogBinding.edtNameServer.text!!.isNotEmpty() &&
                    (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).text.isNotEmpty()
                ) {

                    val name = dialogBinding.edtNameServer.text.toString()
                    val port =
                        (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).text.toString()

                    val newServer = ServersData(name, port)
                    serversAdapter.addServer(newServer)
                    dialog.dismiss()

                } else {
                    Toast.makeText(this, "fill in the blanks!", Toast.LENGTH_SHORT).show()
                }

            }

        }

        binding.searchMain.addTextChangedListener { edtText ->

            if (edtText!!.isNotEmpty()) {

                val cloneServers = listOfServers.clone() as ArrayList<ServersData>
                val filterList = cloneServers.filter { server ->
                    server.nameServer.contains(edtText)
                }

                serversAdapter.setData(ArrayList(filterList))

            } else {
                serversAdapter.setData(listOfServers.clone() as ArrayList<ServersData>)
            }

        }

    }

    override fun onClickDelete(oldServer: ServersData, oldPosition: Int) {
        serversAdapter.removeServer(oldServer, oldPosition)
    }

    override fun onClickEdit(server: ServersData, currentPosition: Int) {

        val dialog = AlertDialog.Builder(this).create()
        val dialogBinding = DialogEditServerBinding.inflate(layoutInflater)
        dialog.setView(dialogBinding.root)
        dialog.show()

        val listOfPort = listOf(

            "110.20 : 433",
            "12.10.11 : 2011",
            "168.190.1.1 : 1128",
            "serversTel.rip : 80"

        )
        val adapterMenu = ArrayAdapter(this, R.layout.view_drop_down, listOfPort)
        (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).setAdapter(
            adapterMenu
        )

        dialogBinding.edtNameServer.setText(server.nameServer)
        (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).setText(server.portServer)

        dialogBinding.btnEditServer.setOnClickListener {

            if (
                (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).text.isNotEmpty() &&
                dialogBinding.edtNameServer.text!!.isNotEmpty()
            ) {

                val server = ServersData(
                    dialogBinding.edtNameServer.text.toString(),
                    (dialogBinding.textInputLayoutMain.editText as AutoCompleteTextView).text.toString()
                )

                serversAdapter.editServer(server , currentPosition)

            } else {
                Toast.makeText(this, "fill in the blanks!", Toast.LENGTH_SHORT).show()
            }

        }

    }

    @SuppressLint("SetTextI18n")
    override fun onClickShowDetails(server: ServersData, currentPosition: Int) {

        val bottomSheet = BottomSheetServerInfo()
        bottomSheet.show(supportFragmentManager , null)

        bottomSheet.binding.txtNameServer.text = "Name : " + server.nameServer
        bottomSheet.binding.txtPortServer.text = "Port : " + server.portServer
    }

}