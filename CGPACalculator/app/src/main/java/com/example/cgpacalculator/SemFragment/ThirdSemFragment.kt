package com.example.cgpacalculator.SemFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cgpacalculator.R
import com.example.cgpacalculator.SemViewModel.ThirdSemViewModel
import kotlinx.android.synthetic.main.fragment_third_sem.*

class ThirdSemFragment : Fragment() {

    private lateinit var viewModel: ThirdSemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_third_sem, container, false)
        viewModel = ViewModelProvider(this).get(ThirdSemViewModel::class.java)
        calculate.setOnClickListener {
            addToArray()
            viewModel.sgpa = result()
            result.text = viewModel.sgpa.toString()
        }
        return binding
    }

    private fun addToArray(){
        viewModel.grades[0] = pcGrade.text.toString().toInt() * 3.0
        viewModel.grades[1] = ffGrade.text.toString().toInt() * 4.0
        viewModel.grades[2] = etGrade.text.toString().toInt() * 4.0
        viewModel.grades[3] = somGrade.text.toString().toInt() * 3.0
        viewModel.grades[4] = oeGrade.text.toString().toInt() * 3.0
        viewModel.grades[5] = ppdGrade.text.toString().toInt() * 1.5
        viewModel.grades[6] = pclGrade.text.toString().toInt() * 1.5
        viewModel.grades[7] = fflGrade.text.toString().toInt() * 1.5
    }

    private fun result() : Double{
        var res = 0.0
        for(i in viewModel.grades){
            res += i
        }
        res /= 21.5
        return res
    }

}