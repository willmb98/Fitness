package com.example.fitness.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.fitness.DatabaseMethods
import com.example.fitness.MainActivity
import com.example.fitness.NavDrawer
import com.example.fitness.R
import kotlinx.android.synthetic.main.fragment_charity.*

class CharityFragment : Fragment() {
    private lateinit var Charity1 : ImageView
    private lateinit var Charity2 : ImageView
    private lateinit var Charity3 : ImageView
    private lateinit var Charity4 : ImageView
    private lateinit var Charity5 : ImageView
    private lateinit var Charity6 : ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_charity, container, false)
        TODO("Rename Charity Section to Special Offers")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        currencyCounter2.text = "You currently have ${(activity as? NavDrawer)!!.currentUserCurrency} coins"
        nameView2.text = "Logged in as ${(activity as? NavDrawer)!!.currentUserName}"

        Charity1 = view.findViewById(R.id.CharitySignUp1)
        Charity2 = view.findViewById(R.id.CharitySignUp2)
        Charity3 = view.findViewById(R.id.CharitySignUp3)
        Charity4 = view.findViewById(R.id.CharitySignUp4)
        Charity5 = view.findViewById(R.id.CharitySignUp5)
        Charity6 = view.findViewById(R.id.CharitySignUp6)

        Charity1.setOnClickListener {
            TODO("Connect to database, add 5 coins")
        }
        Charity2.setOnClickListener {
            TODO("Connect to database, add 50 coins")
        }
        Charity3.setOnClickListener {
            TODO("Connect to database, add 50 coins")
        }
        Charity4.setOnClickListener {
            TODO("Connect to database, add 100 coins")
        }
        Charity5.setOnClickListener {
            TODO("Connect to database, add 150 coins")
        }
        Charity6.setOnClickListener {
            TODO("Connect to database, add 300 coins")
        }
    }
}
