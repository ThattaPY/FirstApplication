package com.thatta.amazing.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thatta.amazing.firstapplication.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameReceived = intent.getStringExtra("name")

        if (nameReceived != "") binding.tvGreeting.text = getString(R.string.greeting, nameReceived)
        else binding.tvGreeting.text = getString(R.string.greeting, "persona")

        binding.tvDice.text = ""


        binding.btnDice.setOnClickListener {
            binding.tvDice.text = getString(R.string.dice_value, getDiceValue().toString())
        }


    }

    fun getDiceValue(): Int {
        return (1..7).random()
    }

}