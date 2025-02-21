package com.example.aplicacionlogin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Ventana2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = intent.getStringExtra("username")
        val principalText = findViewById<TextView>(R.id.principalText)
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        if (username == "admin"){
            principalText.text = "ADMINISTRATION MODE"
            welcomeText.text = "Welcome back boss, what's the plan today?"
        }
        else{
            welcomeText.text = "Welcome, $username, how are you today?"
        }
        val btnLogOut = findViewById<Button>(R.id.btnLogOut)
        btnLogOut.setOnClickListener {
            Toast.makeText(this, "See you later ;)!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}