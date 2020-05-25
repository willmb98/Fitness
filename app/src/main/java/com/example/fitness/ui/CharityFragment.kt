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
import android.net.Uri

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
            openBrowser1(view)
        }
        Charity2.setOnClickListener {

            openBrowser2(view)
        }
        Charity3.setOnClickListener {

            openBrowser3(view)
        }
        Charity4.setOnClickListener {

            openBrowser4(view)
        }
        Charity5.setOnClickListener {

            openBrowser5(view)
        }
        Charity6.setOnClickListener {

            openBrowser6(view)
        }
    }
    private fun openBrowser1(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.clicsargent.org.uk/events/battle-cancer-2020/")
        startActivity(intent)
    }
    private fun openBrowser2(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.childrenwithcancer.org.uk/get-involved/other-ways-to-give/covid-19-uncertainty/?gclid=CjwKCAjw8J32BRBCEiwApQEKgVE1gvpVdGJdhCqKTS2faiItnUO5ME6LlUeF5hJwjXqQ5Ahni8sF7hoCQrQQAvD_BwE")
        startActivity(intent)
    }
    private fun openBrowser3(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.thecalmzone.net/event/home-run-2020/?gclid=CjwKCAjw8J32BRBCEiwApQEKgQB7CtAHVtHH7MuN7iWuqo5_gNowZy6vlkoDY9DgVEUuA6TVX0sAxxoCw7IQAvD_BwE")
        startActivity(intent)
    }
    private fun openBrowser4(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://runforcharity.com/running-events/calendar")
        startActivity(intent)
    }
    private fun openBrowser5(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.cancerresearchuk.org/get-involved/find-an-event/charity-runs")
        startActivity(intent)
    }
    private fun openBrowser6(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.timeoutdoors.com/events/runs/charity-runs")
        startActivity(intent)
    }




}
