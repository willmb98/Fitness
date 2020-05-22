package com.example.fitness.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fitness.*
import kotlinx.android.synthetic.main.fragment_main_page.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencyCounter4.text = "You currently have ${(activity as? NavDrawer)!!.currentUserCurrency} coins"
        nameView4.text = "Logged in as ${(activity as? NavDrawer)!!.currentUserName}"

        val logout = view.findViewById<Button>(R.id.Logoutbtn)

        logout.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
