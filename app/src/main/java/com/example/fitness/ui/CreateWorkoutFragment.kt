package com.example.fitness.ui

import android.content.Context.MODE_APPEND
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitness.R
import kotlinx.android.synthetic.main.fragment_view_workout.*
import kotlinx.android.synthetic.main.fragment_workout.*
import java.io.*


class CreateWorkoutFragment : Fragment() {

    private lateinit var mEditText: EditText
    private lateinit var reps: EditText
    private lateinit var sets: EditText
    private lateinit var WorkoutName: EditText
    private lateinit var mShowText: TextView
    private lateinit var Savebtn: Button
    private lateinit var Loadbtn: Button
    private lateinit var SaveName: Button
    private var FILE_NAME: String = "Example1.txt"




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         return inflater.inflate(R.layout.fragment_workout, container, false)







    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Savebtn = savebtn

        SaveName = savebtn2
        Savebtn.setOnClickListener {
            save()
        }

        SaveName.setOnClickListener {
            SaveWorkout()
        }

        mEditText = edittxt
        sets = edittextsets
        reps = edittextreps
        WorkoutName = edtwrkouttxt
    }

    private fun resetFile(v: View?){
        var file: File
    }

    private fun save() {
        val text: String = mEditText.text.toString() + "\n" + sets.text.toString() + "\n" + reps.text.toString()
        var fos: FileOutputStream? = null
        try {
        fos = context?.openFileOutput(FILE_NAME , MODE_APPEND)
             fos?.write(text.toByteArray())
            mEditText.text.clear()
            sets.text.clear()
            reps.text.clear()
            Toast.makeText(activity, "saved to " + context?.filesDir + "/" + FILE_NAME, Toast.LENGTH_LONG).show()

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }
    private fun SaveWorkout() {
        var text = WorkoutName.text.toString()
        FILE_NAME = text

    }

    private fun load() {
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


