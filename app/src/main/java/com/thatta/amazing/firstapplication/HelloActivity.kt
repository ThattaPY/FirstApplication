package com.thatta.amazing.firstapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thatta.amazing.firstapplication.databinding.ActivityHelloBinding
import com.thatta.amazing.firstapplication.viewModels.HelloActivityViewModel

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val viewModel = ViewModelProvider(this)[HelloActivityViewModel::class.java]
        Log.i("lifeCycle", "onCreate")

        val nameReceived = intent.getStringExtra("name")

        Log.d("name", "$nameReceived")


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

    override fun onStart() {
        super.onStart()
        Log.i("lifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifeCycle", "onResume")
    }


    override fun onPause() {
        super.onPause()

        Log.i("lifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifeCycle", "onDestroy")

    }

}