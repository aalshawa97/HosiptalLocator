package com.example.hospitalfinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.example.hospitalfinder.MapsActivity
import com.example.hospitalfinder.R
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.FirebaseApp

import com.google.firebase.FirebaseOptions




class LoginActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    private var authStateListener: FirebaseAuth.AuthStateListener? = null
    private var googleApiClient: GoogleApiClient? = null
    private var rootRef: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val options = FirebaseOptions.Builder()
            .setApplicationId("1:123140511070:android:a5c84837bb6de83502ebcf") // Required for Analytics.
            .setProjectId("hospitallocator-be5cd") // Required for Firebase Installations.
            .setApiKey("AIzaSyDhp9velxKCu4zR7j8iQJTuJvGY9pjnPoU") // Required for Auth.
            .build()
        FirebaseApp.initializeApp(this, options, "HospitalLocator")
        setContentView(R.layout.activity_login)
        rootRef = FirebaseFirestore.getInstance()

        google_sign_in_button.setOnClickListener { signIn() }

        firebaseAuth = FirebaseAuth.getInstance()
        authStateListener = FirebaseAuth.AuthStateListener { auth ->
            val firebaseUser = auth.currentUser
            if (firebaseUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        googleApiClient = GoogleApiClient.Builder(applicationContext)
                .enableAutoManage(this) { makeText(this, "You got a GoogleApiClient Error!", LENGTH_SHORT).show() }
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build()
    }

    private fun signIn() {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
        startActivityForResult(signInIntent, RC_SIGN_IN)

       //val myIntent = Intent(this@LoginActivity, HomeActivity::class.java)
        //this@LoginActivity.startActivity(myIntent)
    }

    public fun skipLogin(view : View){
        val myIntent = Intent(this@LoginActivity, HomeActivity::class.java)
        this@LoginActivity.startActivity(myIntent)
    }

    public fun chat(view : View){
        val myIntent = Intent(this@LoginActivity, ChatActivity::class.java)
        this@LoginActivity.startActivity(myIntent)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val googleSignInAccount = task.getResult(ApiException::class.java)
                firebaseSignInWithGoogle(googleSignInAccount)
            } catch (e: ApiException) {
                makeText(this, "Google sign in exception", LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseSignInWithGoogle(googleSignInAccount: GoogleSignInAccount) {
        val authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.idToken, null)
        firebaseAuth!!.signInWithCredential(authCredential).addOnCompleteListener(this) {
            val firebaseUser = firebaseAuth!!.currentUser
            if (firebaseUser != null) {
                createUserIfNotExists(firebaseUser)
            }
        }
        makeText(this, "Google sign in success", LENGTH_SHORT).show()
    }

    private fun createUserIfNotExists(firebaseUser: FirebaseUser) {
        val uid = firebaseUser.uid
        val userName = firebaseUser.displayName
        val user = User(uid, userName!!)

        val uidRef = rootRef!!.collection("users").document(uid)
        uidRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (!document.exists()) {
                    uidRef.set(user)
                }
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        firebaseAuth!!.addAuthStateListener(authStateListener!!)
    }

    public override fun onStop() {
        super.onStop()
        if (firebaseAuth != null) {
            firebaseAuth!!.removeAuthStateListener(authStateListener!!)
        }
    }

    companion object {
        //private val TAG = "LoginActivity"
        private const val RC_SIGN_IN = 123
    }

    fun openChat(view: android.view.View) {
        val myIntent = Intent(this@LoginActivity, MainActivityJ::class.java)
        //this@LoginActivity.startActivity(myIntent)
    }
}