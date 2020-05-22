package com.example.fitness

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup

object DatabaseMethods {
    fun checkLogin(username: String, password: String):JSONObject?{
        val json = extractJson("https://demo.agwork.co.uk/db/login.php?username=$username&password=$password")
        return if (json.length() == 1) {
            JSONObject(json[0].toString())
        } else {
            null
        }
    }

    fun register(username: String, password: String, email: String, firstName: String, lastName: String) {
        Jsoup.connect("https://demo.agwork.co.uk/db/register.php?username=$username&password=$password&email=$email&firstname=$firstName&secondname=$lastName").get()
    }

    fun updateCoins(newCoins: Int, userId:Int) {
        Jsoup.connect("https://demo.agwork.co.uk/db/coinupdate.php?newcoins=$newCoins&id=$userId").get()
    }

    fun extractJson(url: String):JSONArray {
        val  doc = Jsoup.connect(url).get()

        var jsonString = doc.body().toString()
        jsonString = jsonString.replace("<body>", "")
        jsonString = jsonString.replace("</body", "")
        Log.i("bodyval", jsonString)
        return JSONArray(jsonString)
    }
}