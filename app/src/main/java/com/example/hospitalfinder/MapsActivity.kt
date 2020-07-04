package com.example.hospitalfinder

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
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mapFragment.onResume()
        mapFragment.allowEnterTransitionOverlap
        mapFragment.activity
    }

    /**
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
        //val locationType: nt = GooglePlacesApi.TYPE_HOSPITAL
        mMap.addMarker(
            MarkerOptions().position(providenceBridgeport).title("Providence Bridgeport")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMercantile).title("Providence Mercantile")
        )
        //mMap.addCircle()
        mMap.moveCamera(CameraUpdateFactory.newLatLng(providenceBridgeport))
       // var phoneNumber = getPhoneNumberFromUserInput();
       // var appVerifier = window.recaptchaVerifier;
//        firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
//            .then(function (confirmationResult) {
//                // SMS sent. Prompt user to type the code from the message, then sign the
//                // user in with confirmationResult.confirm(code).
//                window.confirmationResult = confirmationResult;
//            }).catch(function (error) {
//                // Error; SMS not sent
//                // ...
            //});
    }}

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
