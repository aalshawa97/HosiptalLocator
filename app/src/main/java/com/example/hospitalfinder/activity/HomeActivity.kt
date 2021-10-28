package com.example.hospitalfinder.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.hospitalfinder.MapsActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import java.util.*
import kotlin.concurrent.schedule


class HomeActivity : AppCompatActivity() {
    var mProgressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.hospitalfinder.R.layout.activity_home)
        //Configure sign-in to request the user's ID, email address, and basic profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        //Configure sign-in to request the user's ID, email address, and basic profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        // Build a GoogleSignInClient with the options specified by gso.
        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.

        val account = GoogleSignIn.getLastSignedInAccount(this)
        //updateUI(account)
        Timer("SettingUpProgressBar", false).schedule(1000) {
            val myIntent = Intent(this@HomeActivity, AsyncActivity::class.java)
            this@HomeActivity.startActivity(myIntent)
        }

        Timer("SettingUp", false).schedule(3000) {
            val myIntent = Intent(this@HomeActivity, MapsActivity::class.java)
            this@HomeActivity.startActivity(myIntent)
        }


    }

    /*
    fun onResult(likelyPlaces: PlaceLikelihoodBuffer) {
        for (placeLikelihood in likelyPlaces) {
            place.add(placeLikelihood.place.freeze())
            Log.i("Place = ", placeLikelihood.place.name.toString())
        }
        adapter.notifyDataSetChanged()
        likelyPlaces.release()
    }*/

}
