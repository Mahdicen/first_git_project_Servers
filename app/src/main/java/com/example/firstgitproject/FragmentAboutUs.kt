package com.example.firstgitproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstgitproject.databinding.AboutUsFragmentBinding

class FragmentAboutUs() :Fragment() {
    lateinit var binding :AboutUsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AboutUsFragmentBinding.inflate(layoutInflater , null , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle = arguments
        val title = bundle!!.getString(ABOUT_KEY)

        binding.txtInfo.text = title

    }

}