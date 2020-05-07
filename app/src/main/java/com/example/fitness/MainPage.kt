package com.example.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity


class MainPage : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private lateinit var Logout: Button
    private lateinit var Showpopup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        Logout = findViewById(R.id.Logoutbtn)
        Showpopup = findViewById(R.id.popupbtn)

        Logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun showPopup(view: View) {

        val popup = PopupMenu(this, view)
        popup.setOnMenuItemClickListener(this)
        popup.inflate(R.menu.popup_menu)
        popup.show()
    }


    override fun onMenuItemClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {Toast.makeText(this, "item 1 clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Charity::class.java)
                startActivity(intent)
            return true}
            R.id.item2 -> {Toast.makeText(this, "item 2 clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Store::class.java)
                startActivity(intent)
                return true}
            R.id.item3 -> {Toast.makeText(this, "item 3 clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Createworkout::class.java)
                startActivity(intent)
                return true}
            R.id.item4 -> {Toast.makeText(this, "item 4 clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true}

        }
        return false
    }
}


