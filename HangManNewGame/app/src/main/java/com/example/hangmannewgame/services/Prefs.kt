package com.example.hangmannewgame.services

import android.content.Context

class Prefs(val context: Context) {
    // Name of variable in prefs
    val SHARED_NAME = "MyDtb"
    val SHARED_USER_NAME = "username"
    val SHARED_NOTIS = "notis"
    val SHARED_AUDIO = "music"
    val SHARED_SCORE = "score"

    // Declare and name
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    // Getters and setters
    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME,name).apply()
    }
    fun getName():String{
        return storage.getString(SHARED_USER_NAME,"")!!
    }
    fun saveNotis(notis:Boolean){
        storage.edit().putBoolean(SHARED_NOTIS, notis).apply()
    }

    fun getNotis(): Boolean{
        return storage.getBoolean(SHARED_NOTIS, true)
    }

    fun getMusic():Boolean{
        return storage.getBoolean(SHARED_AUDIO, true)
    }
    fun saveMusic(music:Boolean){
        storage.edit().putBoolean(SHARED_AUDIO, music).apply()
    }

    fun getScore():Int{
        return storage.getInt(SHARED_SCORE, -1)!!
    }
    fun saveScore(score:Int){
        storage.edit().putInt(SHARED_SCORE, score).apply()
    }

}