package com.example.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var Name: EditText
    private lateinit var Password: EditText
    private lateinit var Info: TextView
    private lateinit var Login: Button
    private var counter: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Name = findViewById(R.id.etName)
        Password = findViewById(R.id.etPassword)
        Info = findViewById(R.id.etInfo)
        Login = findViewById(R.id.btnLogin)

        Login.setOnClickListener{
            validate(Name.text.toString(), Password.text.toString())
        }

    }

     private fun validate(userName: String, userPassword: String){

        if((userName == "Admin") && (userPassword == "1234")){
            val intent = Intent(this, NavDrawer::class.java)
            intent.putExtra("username", "admin")
            intent.putExtra("currency", 300)
            startActivity(intent)
        }else{
            counter--
            Info.text = "No of attempts Remaining: " + (counter).toString()
            if(counter == 0){
                Login.isEnabled = false
            }
        }
    }
}

