//Abdullah Mutaz Alshawa
// 7/8/20
// Hospital Locator
// Locates the directions to hospitals for COVID 19 treatment

package com.example.hospitalfinder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
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
        val oregonHealthAndScienceUniversity = LatLng(45.48,-122.81)
        val universityOfWashingtonMedicalCenter = LatLng(46.53,-123.75)
        val providenceWilametteFallsMedicalCenter = LatLng(45.42,-122.72)
        //val locationType: nt = GooglePlacesApi.TYPE_HOSPITAL
        val legacygoodSamaritan = LatLng(45.42,-122.85)
        val providenceCanbyMedicalPlaza = LatLng(45.42,-122.72)
        val legacyMeridianParkMedicalCenter = LatLng(45.42, -122.72)
        val providenceMedicalPlazaSherwood = LatLng(45.42,-122.72)
        val providenceNewbergMedicalCenter = LatLng(45.36,-122.97)
        val oregonClinicSouth = LatLng(45.42,-122.72)
        val clackamasPediatricClinic = LatLng(45.44,-122.80)
        val providenceMedicalGroupBeaverton = LatLng(45.42,-122.72)
        val legacyEmanuelMedicalCenter = LatLng(45.42,-122.72)
        val providenceMilwaukieHospital = LatLng(45.45,-123.06)
        val providenceHoodRiver = LatLng(45.56,-122.69)
        val shrinersHospitalsForChildren = LatLng(45.42,-123.02)
        val peakMedicalNorthwestIncorporated = LatLng(45.42,-122.74)
        val oregonStateHospital = LatLng(45.42,-122.72)
        val legacySilverton = LatLng(45.42,-122.72)
        val samaritanNorthLincolnHospital = LatLng(45.42,-122.72)
        val tualityCommunityHospital = LatLng(45.42,-122.72)
        val kaiserPermanenteWestsideMedicalCenter = LatLng(45.49,-122.92)
        val providenceCentrailiaHospital = LatLng(45.42,-122.72)
        val stJoesphMedicalClinic = LatLng(45.42,-122.72)
        val samaritanAlbanyGeneralHospital = LatLng(44.63, 123.12)
        val asanteThreeRiversMedicalCenter = LatLng(45.42,-122.72)
        val blueMountainHospital = LatLng(44.42,-118.96)
        val goodShepardHealthCareSystem = LatLng(45.42,-122.72)
        val vaPortlandHealthCareSystem =  LatLng(45.48,-122.69)
        val oregonClinicCardiology = LatLng(45.42,-122.72)
        val legacySalmonCreek = LatLng(45.42,-122.72)
        val stCharlesMedicalCenter = LatLng(45.42, -122.72)
        val goodSamaritanRegionalMedicalCenter = LatLng(45.42, -122.72)
        val ProvidenceMedicalCenterMedford = LatLng(45.4160126,-122.7230276)
        val skyLakesMedicalCenter = LatLng(45.42,-122.72)
        val lakeDistrictMedicalCenter = LatLng(45.42, -122.72)
        val samariatanLebanonCommunityHospital = LatLng(44.55, 122.91)
        val peaceHealthPeaceHarborMedicalCenter = LatLng(45.42, -122.72)
        val sacredHeartMedicalCenterUniversityDistrict = LatLng(45.42,-122.72)
        val grandeRondeHospital = LatLng(45.32,-118.11)
        val providenceSwindellsResourceCenter = LatLng(45.42, -122.73)
        val salemHealthHospital = LatLng(45.22,-123.08)
        val stAlphonsusMedicalCenter = LatLng(45.42, -122.72)
        val harneyDistrictHospital = LatLng(44.59,-123.27)
        val columbiaMemorialHospital = LatLng(45.42,-122.72)
        val southernCoosHospitalandHealthCenter = LatLng(45.42, -122.72)
        val woodlandParkHospital = LatLng(38.97,-105.08)
        val curryGeneralHospital = LatLng(45.42, -122.72)
        val coquilleValleyHospital = LatLng(45.42, -122.72)
        val mcKenzieWillametteMedicalCenter = LatLng(45.42,-122.72)
        val midColumbiaMedicalCenterEmergencyRoom = LatLng(45.42,-122.72)

        mMap.addMarker(
            MarkerOptions().position(midColumbiaMedicalCenterEmergencyRoom).title("Mid Columbia Medical Center Emergency Room")
        )
        mMap.addMarker(
            MarkerOptions().position(mcKenzieWillametteMedicalCenter).title("McKenzie Willamette Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(coquilleValleyHospital).title("Coquille Valley Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(curryGeneralHospital).title("Curry General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(woodlandParkHospital).title("Woodland Park Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(legacyEmanuelMedicalCenter).title("Legacy Emanuel Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(southernCoosHospitalandHealthCenter).title("Southern Coos Hospital and Health Center")
        )
        mMap.addMarker(
            MarkerOptions().position(columbiaMemorialHospital).title("Columbia Memorial Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(harneyDistrictHospital).title("Harney District Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(stAlphonsusMedicalCenter).title("St. Alphonsus Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(salemHealthHospital).title("Salem Health Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceSwindellsResourceCenter).title("Providence Swindells Resource Center")
        )
        mMap.addMarker(
            MarkerOptions().position(grandeRondeHospital).title("Grande Ronde Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartMedicalCenterUniversityDistrict).title("Sacred Heart Medical Center University District")
        )
        mMap.addMarker(
            MarkerOptions().position(peaceHealthPeaceHarborMedicalCenter).title("Peace Health Peace Harbor Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(samariatanLebanonCommunityHospital).title("Samariatan Lebanon Community Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(lakeDistrictMedicalCenter).title("Lake District Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(skyLakesMedicalCenter).title("Sky Lakes medical center Klamath Falls")
        )
        mMap.addMarker(
            MarkerOptions().position(ProvidenceMedicalCenterMedford).title("Providence Medical Center Medford ")
        )
        mMap.addMarker(
            MarkerOptions().position(goodSamaritanRegionalMedicalCenter).title("St. Charles Medical Center")
        )

        mMap.addMarker(
            MarkerOptions().position(stCharlesMedicalCenter).title("St. Charles Medical Center")
        )

        mMap.addMarker(
            MarkerOptions().position(legacySalmonCreek).title("Legacy Salmon Creek")
        )

        mMap.addMarker(
            MarkerOptions().position(oregonClinicCardiology).title("Oregon Clinic Cardiology")
        )
        mMap.addMarker(
            MarkerOptions().position(vaPortlandHealthCareSystem).title("Veteran Affairs Portland Health Care System")
        )
//
        mMap.addMarker(
            MarkerOptions().position(oregonHealthAndScienceUniversity).title("Oregon Health and Science University")
        )
        mMap.addMarker(
            MarkerOptions().position(goodShepardHealthCareSystem).title("Good Shepard Health Care System")
        )
        mMap.addMarker(
            MarkerOptions().position(blueMountainHospital).title("Blue Mountain Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(asanteThreeRiversMedicalCenter).title("Asante Three Rivers Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(samaritanAlbanyGeneralHospital).title("Samaritan Albany General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(stJoesphMedicalClinic).title("St. Joesph Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceCentrailiaHospital).title("Providence Centrailia Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(kaiserPermanenteWestsideMedicalCenter).title("Kaiser Permanente Westside Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(tualityCommunityHospital).title("Tuality Community Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(samaritanNorthLincolnHospital).title("Samartian North Lincoln Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(legacySilverton).title("Legacy Silverton Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(oregonStateHospital).title("Oregon State Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(peakMedicalNorthwestIncorporated).title("Peak Medical Northwest Incorporated")
        )
        mMap.addMarker(
            MarkerOptions().position(shrinersHospitalsForChildren).title("Shriners Hospital for Children")
        )
        mMap.addMarker(
                    MarkerOptions().position(providenceHoodRiver).title("Providence Hood River Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMilwaukieHospital).title("Providence Milwaukie Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMedicalGroupBeaverton).title("Providence Medical Group Beaverton")
        )
        mMap.addMarker(
            MarkerOptions().position(clackamasPediatricClinic).title("Clackamas Pediatric Clinic")
        )
        mMap.addMarker(
            MarkerOptions().position(oregonClinicSouth).title("Oregon Clinic South")
        )

        mMap.addMarker(
            MarkerOptions().position(providenceNewbergMedicalCenter).title("Providence Newberg Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMedicalPlazaSherwood).title("Providence Medical Plaza Sherwood")
        )
        mMap.addMarker(
            MarkerOptions().position(legacyMeridianParkMedicalCenter).title("Legacy Meridian Park Medical Plaza")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceCanbyMedicalPlaza).title("Providence Medical Plaza")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceWilametteFallsMedicalCenter).title("Providence Wilamette Falls Medical Center")
        )
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
//    val getString
//    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString.default_web_client_id)
//    val requestCode = 0
//    if (requestCode  == null) {
//
//    }
//    try {
//        //val builderInference
//    } catch (e:
//                     Exception) {
//    }
    // var  dbReference
//    // Turn off phone auth app verification.
//    val firebase = null
//
//    //Initialize the variables
//    val userName = "userName"


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
