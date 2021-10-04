package com.example.hospitalfinder.activity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.Toast
import com.example.hospitalfinder.MapsActivity
import java.util.Timer
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.hospitalfinder.R.layout.activity_home)
        Timer("SettingUp", false).schedule(3000) {
            val myIntent = Intent(this@HomeActivity, MapsActivity::class.java)
            this@HomeActivity.startActivity(myIntent)
        }
    }
}
