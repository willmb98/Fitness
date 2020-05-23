package com.example.fitness.ui

import android.content.Context.MODE_APPEND
import android.content.Context.MODE_PRIVATE
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
import org.w3c.dom.Text
import java.io.*
import java.lang.StringBuilder
import java.nio.file.Files.*


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
        var v = inflater.inflate(R.layout.fragment_workout, container, false)


        Savebtn = v.findViewById(R.id.savebtn)
        Loadbtn = v.findViewById(R.id.loadbtn)
        SaveName = v.findViewById(R.id.savebtn2)
        Savebtn.setOnClickListener {
        save(view)
        }
        Loadbtn.setOnClickListener {
            load(view)
        }
        SaveName.setOnClickListener {
            SaveWorkout(view)
        }

        mEditText = v.findViewById(R.id.edittxt)
        sets = v.findViewById(R.id.edittextsets)
        reps = v.findViewById(R.id.edittextreps)
        mShowText = v.findViewById(R.id.textoutput)
        WorkoutName = v.findViewById(R.id.edtwrkouttxt)
        return v

        //TODO("Connect CreateWorkout to database, uploading the workout")
        //TODO("Add Option (Potentially new page) to add daily steps")

    }
    private fun resetFile(v: View?){
        var file: File
    }


    private fun save(v: View?) {
        val text: String = "\n "+ mEditText.text.toString() + "\n" + sets.text.toString() + "\n" + reps.text.toString()
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
    private fun SaveWorkout(v: View?) {
        var text = WorkoutName.text.toString()
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


