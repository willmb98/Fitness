package com.example.fitness.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.example.fitness.DatabaseMethods
import com.example.fitness.NavDrawer
import com.example.fitness.R
import kotlinx.android.synthetic.main.fragment_store.*
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

class StoreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencyCounter.text = "coins: ${(activity as? NavDrawer)!!.currentUserCurrency}"
        nameView.text = "logged in as: ${(activity as? NavDrawer)!!.currentUserName}"

        val buttonList = mutableListOf<ImageButton>()
        for (child in sequenceOf(leftLayout.children, rightLayout.children).flatten()) {
            if (child is ImageButton) {
                buttonList.add(child)
            }
        }

        for (button in buttonList) {
            button.setOnClickListener {
                val itemValue = button.tag.toString().toInt()

                if ((activity as? NavDrawer)!!.currentUserCurrency > itemValue) {
                    val builder = AlertDialog.Builder(requireContext())
                    builder.setTitle("Confirm purchase")
                    builder.setMessage("Are you sure you want to spend ${button.tag} coins on this?")
                    builder.setPositiveButton("YES"){dialog, which ->
                        when (itemValue) {
                            50 -> Toast.makeText(requireContext(), "streak frozen!", Toast.LENGTH_SHORT).show()

                            100 -> Toast.makeText(requireContext(), "new exercise unlocked!", Toast.LENGTH_SHORT).show()

                            else -> Toast.makeText(requireContext(), "check your email for a code!", Toast.LENGTH_SHORT).show()
                        }

                        (activity as NavDrawer).currentUserCurrency -= itemValue
                        runBlocking (newSingleThreadContext("NetworkThread")) {
                            DatabaseMethods.updateCoins((activity as NavDrawer).currentUserCurrency, (activity as NavDrawer).currentUserDbId)
                        }
                        currencyCounter.text = "coins: ${(activity as? NavDrawer)!!.currentUserCurrency}"
                    }

                    builder.setNegativeButton("No"){dialog,which ->
                        Toast.makeText(requireContext(), "purchase canceled", Toast.LENGTH_SHORT).show()
                    }
                    builder.show()
                } else {
                    Toast.makeText(requireContext(), "not enough coins!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
