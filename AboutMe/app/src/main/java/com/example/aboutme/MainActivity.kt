package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val myName : MyName = MyName("Aman")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        binding.myName = myName

        done.setOnClickListener {
            val name = etMovie.editableText.toString()
            tvMovie.text = name
            etMovie.visibility = View.GONE
            done.visibility = View.GONE
            tvMovie.visibility = View.VISIBLE
            // Hide the keyboard.
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            val view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }

    }
}