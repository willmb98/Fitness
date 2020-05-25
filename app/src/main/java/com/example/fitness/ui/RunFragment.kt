package com.example.fitness.ui

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitness.DatabaseMethods
import com.example.fitness.NavDrawer
import com.example.fitness.R
import kotlinx.android.synthetic.main.fragment_run.*
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.math.round


class RunFragment : Fragment() {

    private var running = false
    private var pauseOffset: Long = 0
    private var distance:Double = 0.00
    private var secIntervals = 1
    private var steps = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_run, container, false)
    }

    //timer code from https://codinginflow.com/tutorials/android/chronometer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chronometer.setFormat("Time: %s")
        chronometer.setBase(SystemClock.elapsedRealtime())
        chronometer.setOnChronometerTickListener { chronometer ->
            //every 1 second add more to the simulated run
            if (SystemClock.elapsedRealtime() - chronometer.base >= (1000 * secIntervals)) {
                secIntervals++
                distance += 0.002
                steps += 2
                tvSteps.text = "Steps: ${steps}"
                tvDistance.text = "Km run: ${distance.round(2)}"
            }
        }

        play_button.setOnClickListener {
            if (!running) {
                chronometer.base = (SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                running = true;
            }
        }
        pause_button.setOnClickListener {
            if (running) {
                chronometer.stop()
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase()
                running = false
            }
        }
        stop_button.setOnClickListener {
            chronometer.setBase(SystemClock.elapsedRealtime())
            chronometer.stop()

            val coinsToAdd = steps*10
            (activity as NavDrawer).currentUserCurrency = (activity as NavDrawer).currentUserCurrency + coinsToAdd
            runBlocking (newSingleThreadContext("NetworkThread")) {
                DatabaseMethods.updateCoins((activity as NavDrawer).currentUserCurrency, (activity as NavDrawer).currentUserDbId)
            }
            Toast.makeText(activity, "you earnt $coinsToAdd coins for that run!", Toast.LENGTH_LONG).show()
            (activity as NavDrawer).navController.navigate(R.id.nav_home)

            running = false
            steps = 0
            distance = 0.0
        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}
