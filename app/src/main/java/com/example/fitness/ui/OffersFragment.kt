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
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

class OffersFragment : Fragment() {
    private lateinit var Charity1 : ImageView
    private lateinit var Charity2 : ImageView
    private lateinit var Charity3 : ImageView
    private lateinit var Charity4 : ImageView
    private lateinit var Charity5 : ImageView
    private lateinit var Charity6 : ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_charity, container, false)
        //TODO("Rename Charity Section to Special Offers")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        currencyCounter2.text = "coins: ${(activity as? NavDrawer)!!.currentUserCurrency}"
        nameView2.text = "Logged in as ${(activity as? NavDrawer)!!.currentUserName}"

        CharitySignUp1.setOnClickListener {
            (activity as NavDrawer).currentUserCurrency += 5
            updateCoins()
        }
        CharitySignUp2.setOnClickListener {
            (activity as NavDrawer).currentUserCurrency += 50
            updateCoins()
        }
        CharitySignUp3.setOnClickListener {
            (activity as NavDrawer).currentUserCurrency += 50
            updateCoins()
        }
        CharitySignUp4.setOnClickListener {
            (activity as NavDrawer).currentUserCurrency += 100
            updateCoins()
        }
        CharitySignUp5.setOnClickListener {
            (activity as NavDrawer).currentUserCurrency += 150
            updateCoins()
        }
        CharitySignUp6.setOnClickListener {
            (activity as NavDrawer).currentUserCurrency += 300
            updateCoins()
        }
    }

    fun updateCoins() {
        runBlocking (newSingleThreadContext("NetworkThread")) {
            DatabaseMethods.updateCoins((activity as NavDrawer).currentUserCurrency, (activity as NavDrawer).currentUserDbId)
        }
        currencyCounter2.text = "coins: ${(activity as NavDrawer).currentUserCurrency}"
    }
}
