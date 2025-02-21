package com.example.aplicacionlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Username = findViewById<EditText>(R.id.Usuario)
        val Password = findViewById<EditText>(R.id.Contraseña)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        var cont_fail = 0

        data class User(val username: String, val password: String)
        val users = listOf(
            User("admin", "adminpswrd"),
            User("user1", "password1"),
            User("Mario","Mario123")
        )

        btnLogin.setOnClickListener {
            val username = Username.text.toString()
            val password = Password.text.toString()
            if (cont_fail == 3){
                Toast.makeText(this, "Too many failed attempts, please try again later", Toast.LENGTH_SHORT).show()
                finish()
            }
            else{
                if (users.any { it.username == username && it.password == password }) {
                    val intent = Intent(this, Ventana2::class.java)
                    intent.putExtra("username", username)
                    Toast.makeText(this, "Successfully logged in, $username!", Toast.LENGTH_SHORT).show()
                    Username.text.clear()
                    Password.text.clear()
                    cont_fail = 0
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Invalid credentials, attempts left: ${3 - cont_fail}", Toast.LENGTH_SHORT).show()
                    cont_fail++
                }
            }
        }
    }
}