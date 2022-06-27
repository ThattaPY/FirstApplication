package com.thatta.amazing.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tilName = findViewById<TextInputEditText>(R.id.til_name)
        val btnGreeting = findViewById<Button>(R.id.btn_greeting)

        btnGreeting.setOnClickListener {
            val name = tilName.text.toString()
            val intent = Intent(this, HelloActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

    }
}