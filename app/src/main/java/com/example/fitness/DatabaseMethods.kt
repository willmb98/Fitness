package com.example.fitness

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object DatabaseMethods {
    fun checkLogin(userName: String, password: String):JSONObject?{
        val json = extractJson("https://demo.agwork.co.uk/db/login.php?username=$userName&password=$password")
        return if (json.length() == 1) {
            JSONObject(json[0].toString())
        } else {
            null
        }
    }

    fun register(userId: String, password: String) {

    }

    fun updateCoins(newCoins: Int, userId:Int) {
        Jsoup.connect("https://demo.agwork.co.uk/db/coinupdate.php?newcoins=$newCoins&id=$userId").get()
        Log.i("url", "https://demo.agwork.co.uk/db/coinupdate.php?newcoins=$newCoins&id=$userId")
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