package com.example.hospitalfinder.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.autofill.AutofillManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
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
import java.util.*
import kotlin.concurrent.schedule

class LoginActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    private var authStateListener: FirebaseAuth.AuthStateListener? = null
    private var googleApiClient: GoogleApiClient? = null
    private var rootRef: FirebaseFirestore? = null
    lateinit var IVPreviewImage: ImageView
    private var imageUri: Uri? = null

    // One Button
    var BSelectImage: Button? = null
    val pickImage = 100
    //Constant to compare the activity result code
    var SELECT_PICTURE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val options = FirebaseOptions.Builder()
            .setApplicationId("1:123140511070:android:a5c84837bb6de83502ebcf") // Required for Analytics.
            .setProjectId("hospitallocator-be5cd") // Required for Firebase Installations.
            .setApiKey("AIzaSyDhp9velxKCu4zR7j8iQJTuJvGY9pjnPoU") // Required for Auth.
            .build()
        //If the application name is not initialized!
        if(R.string.app_name == null)
        {
            FirebaseApp.initializeApp(this, options, "HospitalLocator")
        }
        setContentView(R.layout.activity_login)
        BSelectImage = findViewById(R.id.BSelectImage)
        IVPreviewImage = findViewById(R.id.imageView)
        BSelectImage?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
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
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            IVPreviewImage.setImageURI(imageUri)
        }
        else if (requestCode == RC_SIGN_IN) {
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

    // this function is triggered when
    // the Select Image Button is clicked
    fun imageChooser(view: android.view.View) {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        //Pass the constant to compare it with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }


    //@SuppressLint("NewApi")
   // @RequiresApi(Build.VERSION_CODES.M)
    fun openChat(view: android.view.View) {
        //val autofillManager = requireContext().getSystemService(AutofillManager::class.java)
        //autofillManager.commit()
        Toast.makeText(this, "Opening chat", Toast.LENGTH_LONG).show()
        Log.d("LoginActivity", "openChat: ")
        val myIntent = Intent(this@LoginActivity, MainActivityJ::class.java)
        this@LoginActivity.startActivity(myIntent)

        Toast.makeText(this, "Setting up chat", Toast.LENGTH_LONG).show()
        Log.d("Opening messenger", "openChat: ")
        Timer("SettingUp", false).schedule(20000) {
            val myIntent = Intent(this@LoginActivity, ChatActivity::class.java)
            //this@LoginActivity.startActivity(myIntent)
        }

        this@LoginActivity.startActivity(myIntent)

        Toast.makeText(this, "Done setting up chat", Toast.LENGTH_LONG).show()
    }
}