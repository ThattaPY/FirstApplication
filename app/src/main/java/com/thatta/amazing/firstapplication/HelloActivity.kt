package com.thatta.amazing.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thatta.amazing.firstapplication.databinding.ActivityHelloBinding
import com.thatta.amazing.firstapplication.viewModels.HelloActivityViewModel

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[HelloActivityViewModel::class.java]

        val nameReceived = intent.getStringExtra("name")

        if (nameReceived != "") binding.tvGreeting.text = getString(R.string.greeting, nameReceived)
        else binding.tvGreeting.text = getString(R.string.greeting, "persona")

        binding.tvDice.text = ""

        viewModel.diceValue.observe(this) {
            binding.tvDice.text = getString(R.string.dice_value, it.toString())
        }

        binding.btnDice.setOnClickListener {
            viewModel.getDiceValue()
        }
    }

}