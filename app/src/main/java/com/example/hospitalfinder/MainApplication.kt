package com.example.hospitalfinder

import android.content.Context

class MainApplication {

    init{
        instance = this
    }

    companion object{
        private var instance: MainApplication? = null

        fun applicationContext() : Unit = Unit

        //return instance!!.applicationContext
    }

}

fun onCreate(){
    onCreate()

    // initialize for any

    // Use ApplicationContext.
    // example: SharedPreferences etc...
    val context: Unit = MainApplication.applicationContext()
}
