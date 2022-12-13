package com.example.firstgitproject

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.firstgitproject.databinding.MenuListDialogFragmentBinding

const val ABOUT_KEY = "AboutKey"
class DialogFragmentMenuList() :DialogFragment() {
    lateinit var binding :MenuListDialogFragmentBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = AlertDialog.Builder(requireContext()).create()
        binding = MenuListDialogFragmentBinding.inflate(layoutInflater , null , false)
        dialog.setView(binding.root)

        binding.infoLine.setOnClickListener {

            val bundle = Bundle()
            val nameFragment = binding.txtAboutUs.text.toString()

            bundle.putString(ABOUT_US_KEY , nameFragment)

            val aboutUsFragment = FragmentAboutUs()
            aboutUsFragment.arguments = bundle

            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.frameAboutUs , aboutUsFragment)
            transaction.addToBackStack(null)

        }

        return dialog
    }

}