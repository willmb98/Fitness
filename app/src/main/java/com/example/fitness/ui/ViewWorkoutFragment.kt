package com.example.fitness.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fitness.*
import java.io.*


class ViewWorkoutFragment : Fragment() {


    private var FILE_NAME: String = "Example1.txt"
    private lateinit var mShowText: TextView
    private lateinit var Loadbtn: Button
    private lateinit var Setbtn: Button
    private lateinit var mEditText: EditText



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_view_workout, container, false)
        mShowText = v.findViewById(R.id.textOutput)
        Loadbtn = v.findViewById(R.id.loadbtn)
        mEditText = v.findViewById(R.id.workoutName)
        Setbtn = v.findViewById(R.id.setbtn)

        Loadbtn.setOnClickListener {
            load(view)
        }
        Setbtn.setOnClickListener {
            SaveWorkout(view)
        }
        return v



    }

    private fun SaveWorkout(v: View?) {
        var text = mEditText.text.toString()
        FILE_NAME = text

    }




    private fun load(v: View?) {
        var fis: FileInputStream? = null

        try {

            fis = context?.openFileInput(FILE_NAME)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)

            val lines = br.readLines()
            val output = lines.joinToString("\n")
            mShowText.text = output
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                fis?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}
