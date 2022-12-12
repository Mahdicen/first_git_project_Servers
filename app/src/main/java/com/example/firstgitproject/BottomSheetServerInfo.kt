package com.example.firstgitproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstgitproject.databinding.ServerBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetServerInfo() :BottomSheetDialogFragment() {
    lateinit var binding :ServerBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ServerBottomSheetBinding.inflate(layoutInflater , null , false)
        return binding.root

    }

}