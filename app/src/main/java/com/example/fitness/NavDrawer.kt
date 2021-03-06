package com.example.fitness

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import kotlin.properties.Delegates

class NavDrawer : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    var currentUserCurrency by Delegates.notNull<Int>()
    var currentUserName by Delegates.notNull<String>()
    var currentUserDbId by Delegates.notNull<Int>()

    //built in navigation drawer activity

    override fun onCreate(savedInstanceState: Bundle?) {
        currentUserCurrency = intent.extras!!.getInt("currency")
        currentUserName = intent.extras!!.getString("username")!!
        currentUserDbId = intent.extras!!.getInt("dbID")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_draw)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_shop, R.id.nav_Charity
            ), drawerLayout
        )

        navView.menu.findItem(R.id.nav_Workout).setOnMenuItemClickListener {
            navView.setCheckedItem(R.id.nav_Workout)
            navController.navigate(R.id.nav_workout)
            drawerLayout.closeDrawers()
            true
        }

        navView.menu.findItem(R.id.nav_view_run).setOnMenuItemClickListener {
            navView.setCheckedItem(R.id.nav_view_run)
            navController.navigate(R.id.runFragment)
            drawerLayout.closeDrawers()
            true
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        Log.i("test", navController.navigatorProvider.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_draw, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
