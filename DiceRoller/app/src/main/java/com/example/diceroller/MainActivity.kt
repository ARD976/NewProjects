package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var display : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }

        display = findViewById(R.id.display)

    }

    private fun rollDice() {
        val random = Random().nextInt(6)+1
        when(random){
            1-> display.setImageResource(R.drawable.dice_1)
            2-> display.setImageResource(R.drawable.dice_2)
            3-> display.setImageResource(R.drawable.dice_3)
            4-> display.setImageResource(R.drawable.dice_4)
            5-> display.setImageResource(R.drawable.dice_5)
            6-> display.setImageResource(R.drawable.dice_6)
        }
    }
}