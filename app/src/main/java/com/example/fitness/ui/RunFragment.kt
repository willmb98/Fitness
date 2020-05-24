package com.example.fitness.ui

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitness.R
import kotlinx.android.synthetic.main.fragment_run.*
import kotlin.math.round


class RunFragment : Fragment() {

    private var running = false
    private var pauseOffset: Long = 0
    private var distance:Double = 0.00
    private var secIntervals = 1
    private var steps:Int = 0
    private var duration: Long = 0

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
            //every 10 seconds add more to the simulated run
            if (SystemClock.elapsedRealtime() - chronometer.base >= (1000 * secIntervals)) {
                secIntervals++
                distance += 0.002
                steps += 2
                tvSteps.text = "Steps: ${steps}"
                tvDistance.text = "Km run: ${distance.round(2)}"
            }
        }

        startBtn.setOnClickListener {
            if (!running) {
                chronometer.base = (SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                running = true;
            }
        }
        pauseBtn.setOnClickListener {
            if (running) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
            }
        }
        resetBtn.setOnClickListener {
            chronometer.setBase(SystemClock.elapsedRealtime());
            steps = 0;
            distance = 0.0;
            tvSteps.text = "Steps: ${steps}"
            tvDistance.text = "Km run: ${distance.round(2)}"

            TODO("Send steps/distance/duration/todays date and time to database")
        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}
