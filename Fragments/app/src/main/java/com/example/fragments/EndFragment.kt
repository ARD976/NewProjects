package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fragments.databinding.FragmentEndBinding

class EndFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentEndBinding>(inflater , R.layout.fragment_end , container , false)
        binding.nextButton.setOnClickListener { view : View ->
            Navigation.findNavController(view).navigate(R.id.action_endFragment_to_imageFragment)
        }
        return binding.root
    }

}