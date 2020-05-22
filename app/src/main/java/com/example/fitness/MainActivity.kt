package com.example.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private var counter: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //you can just use view ids in kotlin, no need to do findViewById
        btnLogin.setOnClickListener {
            validate(etName.text.toString(), etPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            etEmail.visibility = View.VISIBLE
            etFirstName.visibility = View.VISIBLE
            etLastName.visibility = View.VISIBLE
            etPassword.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            btnLogin.visibility = View.GONE

            btnRegister.setOnClickListener {
                runBlocking (newSingleThreadContext("NetworkThread")) {
                    DatabaseMethods.register(
                        etName.text.toString(),
                        etPassword.text.toString(),
                        etEmail.text.toString(),
                        etFirstName.text.toString(),
                        etLastName.text.toString()
                    )
                }
                Toast.makeText(
                    applicationContext,
                    "registration successful, logging in now...",
                    Toast.LENGTH_SHORT
                ).show()
                validate(etName.text.toString(), etPassword.text.toString())
            }
        }
    }

    private fun validate(userName: String, userPassword: String) {
        val dbResults = runBlocking(newSingleThreadContext("NetworkThread")) {
            DatabaseMethods.checkLogin(userName, userPassword)
        }
        Log.i("results", dbResults.toString())
        if (dbResults != null) {
            val intent = Intent(this, NavDrawer::class.java)
            intent.putExtra("dbID", dbResults.getString("person_id_pk").toInt())
            intent.putExtra("username", dbResults.getString("username"))
            intent.putExtra("currency", dbResults.getString("total_currency").toInt())
            startActivity(intent)
        } else {

            counter--
            tvInfo.text = "Attempts remaining: $counter"
            if (counter == 0) {
                Toast.makeText(
                    applicationContext,
                    "too many login attempts, try again later!",
                    Toast.LENGTH_SHORT
                ).show()
                btnLogin.isEnabled = false
            }
        }
    }
}

