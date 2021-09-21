package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fragments.databinding.FragmentImageBinding


class ImageFragment : Fragment() {

    private lateinit var binding : FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate( inflater , R.layout.fragment_image , container , false)
        binding.nextButton.setOnClickListener { view : View ->
            Navigation.findNavController(view).navigate(R.id.action_imageFragment_to_endFragment)
        }
        return binding.root
    }

}