package com.example.fitness

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Charity : AppCompatActivity() {
    private lateinit var Charity1 : ImageView
    private lateinit var Charity2 : ImageView
    private lateinit var Charity3 : ImageView
    private lateinit var Charity4 : ImageView
    private lateinit var Charity5 : ImageView
    private lateinit var Charity6 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity)

        Charity1 = findViewById(R.id.CharitySignUp1)
        Charity2 = findViewById(R.id.CharitySignUp2)
        Charity3 = findViewById(R.id.CharitySignUp3)
        Charity4 = findViewById(R.id.CharitySignUp4)
        Charity5 = findViewById(R.id.CharitySignUp5)
        Charity6 = findViewById(R.id.CharitySignUp6)

        Charity1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Charity2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Charity3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Charity4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Charity5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Charity6.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
