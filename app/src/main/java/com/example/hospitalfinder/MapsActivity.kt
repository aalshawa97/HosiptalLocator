//Abdullah Mutaz Alshawa
// 7/8/20
// Hospital Locator
// Locates the directions to hospitals for COVID 19 treatment

package com.example.hospitalfinder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //super.getResources()
        setContentView(R.layout.activity_maps)
//        setContentView(R.layout.news)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mapFragment.onResume()
        mapFragment.allowEnterTransitionOverlap
        mapFragment.activity

        if(mapFragment.isRemoving)
            println("Application is closing!")

        //mapFragment.onEnterAmbient()
        //return inflater.inflate(R.layout.article_view, container, false)

    }

    /**        setContentView(R.layout.news_articles)

     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    fun getPhoneNumberFromUserInput()
    {
        val number = Integer.valueOf(readLine())
        return number as Unit
    }
    override fun onMapReady(googleMap: GoogleMap) {

        authenticateFirebase()
        mMap = googleMap

        // Add a marker in Providence Bridgeport and move the camera
        val providenceBridgeport = LatLng(45.39, -122.75)
        val providenceMercantile = LatLng(45.42, -122.72)
        val providenceStVincent = LatLng(45.46,-122.792)
        val universityOfWashingtonMedicalCenter = LatLng(46.53,-123.75)
        //val locationType: nt = GooglePlacesApi.TYPE_HOSPITAL
        val legacygoodSamaritan = LatLng(45.42,-122.85)
        mMap.addMarker(
            MarkerOptions().position(legacygoodSamaritan).title("Legacy Good Samaritan")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceBridgeport).title("Providence Bridgeport")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMercantile).title("Providence Mercantile")
        )

        mMap.addMarker(
            MarkerOptions().position(providenceStVincent).title("Providence St. Vincent")
        )
        mMap.addMarker(
            MarkerOptions().position(universityOfWashingtonMedicalCenter).title("University of Washington Medical Center")
        )
        //mMap.addCircle()
        mMap.moveCamera(CameraUpdateFactory.newLatLng(providenceBridgeport))


        val hospitalUrl = "http://maps.google.co.uk/maps?q=Hospital&hl=en"
        
        
       val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hospitalUrl));
       // val activityIntent = Intent(this,isActivityTransitionRunning::class.java) startActivity(intent)

        //String string = ""
//            intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
//        startActivity(intent);
       // var phoneNumber = getPhoneNumberFromUserInput();
       // var appVerifier = window.recaptchaVerifier;
//        firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
//            .then(function (confirmationResult) {
//                // SMS sent. Prompt user to type the code from the message, then sign the
//                // user in with confirmationResult.confirm(code).
//                window.confirmationResult = confirmationResult;
//            }).catch(function (error) {
//                // Error; SMS not senthttps://www.linkedin.com/in/abdullah-alshawa-691b23132/
//                // ...
            //});
    }}

//private infix fun Parcelable.startActivity(intent: Intent): Any {
//
//}


//private fun firebaseAuthWithGoogle(idToken: String) {
//    val credential = GoogleAuthProvider.getCredential(idToken, null)
//    auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithCredential:success")
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    // ...
//                    Snackbar.make(view, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
//                    updateUI(null)
//                }
//
//                // ...
//            }
//}

fun findHospitalNearby()
{
    var R = 6371; // km
    val lat2 = 0
    val lat1 = 0
    val lon2 = 0
    val lon1 = 0
//    var dLat = (lat2-lat1).toRad();
//    var dLon = (lon2-lon1).toRad();
//    var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
//            Math.cos(lat1.toRad()) * Math.cos(lat2.toRad()) *
//            Math.sin(dLon/2) * Math.sin(dLon/2);
  //  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    //var d = R * c;
}
fun authenticateFirebase()
{
    // Turn off phone auth app verification.
    val firebase = null
//    firebase.auth().settings.appVerificationDisabledForTesting = true;
//
//    var phoneNumber = "+16505554567";
//    var testVerificationCode = "123456";
//
//// This will render a fake reCAPTCHA as appVerificationDisabledForTesting is true.
//// This will resolve after rendering without app verification.
//    var appVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container');
//// signInWithPhoneNumber will call appVerifier.verify() which will resolve with a fake
//// reCAPTCHA response.
//    firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
//        .then(function (confirmationResult) {
//            // confirmationResult can resolve with the whitelisted testVerificationCode above.
//            return confirmationResult.confirm(testVerificationCode)
//        }).catch(function (error) {
//            // Error; SMS not sent
//            // ...
//        });
}
