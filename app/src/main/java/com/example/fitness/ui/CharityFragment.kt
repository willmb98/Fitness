package com.example.fitness.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitness.MainActivity
import com.example.fitness.R

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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Charity1 = view.findViewById(R.id.CharitySignUp1)
        Charity2 = view.findViewById(R.id.CharitySignUp2)
        Charity3 = view.findViewById(R.id.CharitySignUp3)
        Charity4 = view.findViewById(R.id.CharitySignUp4)
        Charity5 = view.findViewById(R.id.CharitySignUp5)
        Charity6 = view.findViewById(R.id.CharitySignUp6)

        Charity1.setOnClickListener {
            TODO("implement onclick")
        }
        Charity2.setOnClickListener {
            TODO("implement onclick")
        }
        Charity3.setOnClickListener {
            TODO("implement onclick")
        }
        Charity4.setOnClickListener {
            TODO("implement onclick")
        }
        Charity5.setOnClickListener {
            TODO("implement onclick")
        }
        Charity6.setOnClickListener {
            TODO("implement onclick")
        }
    }
}
