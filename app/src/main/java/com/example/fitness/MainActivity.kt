package com.example.fitness

import android.content.Intent
import kotlinx.coroutines.async
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    private var counter: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.etName)
        val password = findViewById<EditText>(R.id.etPassword)
        val login = findViewById<Button>(R.id.btnLogin)

        login.setOnClickListener{
            validate(name.text.toString(), password.text.toString())
        }

    }

     private fun validate(userName: String, userPassword: String) {
         val dbResults = runBlocking (newSingleThreadContext("NetworkThread")) {
            DatabaseMethods.checkLogin(userName, userPassword)
        }
         Log.i("results", dbResults.toString())
        if(dbResults != null){
            val intent = Intent(this, NavDrawer::class.java)
            intent.putExtra("dbID", dbResults.getString("person_id_pk").toInt())
            intent.putExtra("username", dbResults.getString("username"))
            intent.putExtra("currency", dbResults.getString("total_currency").toInt())
            startActivity(intent)
        }else{
            val login = findViewById<Button>(R.id.btnLogin)
            val info = findViewById<TextView>(R.id.etInfo)

            counter--
            info.text = "No of attempts Remaining: $counter"
            if(counter == 0){
                login.isEnabled = false
            }
        }
    }
}

