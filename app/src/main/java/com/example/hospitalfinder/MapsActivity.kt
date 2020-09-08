//Abdullah Mutaz Alshawa
//7/8/20
//Hospital Locator
//Locates the directions to hospitals for COVID 19 treatment using the Google Maps API. Uses Kotlin as a programming language.
//Personal project on github , username aalshawa97
package com.example.hospitalfinder


import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.net.Uri.Builder
import android.util.Log
//This makes the application an activity
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.xml.parsers.DocumentBuilder
import android.widget.Button
import com.google.android.gms.maps.*
import javax.xml.parsers.DocumentBuilderFactory

interface location {
    fun getLocations(): List<LocationSource>
    //fun getDirections(channelId: Long): List<Direction>
}

//val intent = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS).apply {
//    putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
//    putExtra(Settings.EXTRA_CHANNEL_ID, myNotificationChannel.getId())
//}
//startActivity(intent)

fun main(args: Array<String>)
{
    println("Hello, World")
//    val me = Person("Abdullah","Mutaz" "Alshawa")
//    val you = Person("Janet", "Chung", "Yang")
//    val location = object {
//        var xPosition = 200
//        var yPosition = 400
//        fun printIt(){
//            println("Position = ($xPosition, $yPosition)")
//        }
//    }
//    location.printIt()
//    location.xPosition = 200
//    location.yPosition = 400

}
//import kotlinx.android.synthetic.main.fragment_login.*
//class UserProfileViewModel() : ViewModel(), Parcelable {
//    val userId : String = TODO()
//    val user : User = TODO()
//
//    constructor(parcel: Parcel) : this() {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<UserProfileViewModel> {
//        override fun createFromParcel(parcel: Parcel): UserProfileViewModel {
//            return UserProfileViewModel(parcel)
//        }
//
//        override fun newArray(size: Int): Array<UserProfileViewModel?> {
//            return arrayOfNulls(size)
//        }

//}
//import pythonAppiumClient[

//from appium import webdriver

//import com.google.android.po
//class BaeldungNewsletter : IObservable {
//    override val observers: ArrayList<IObserver> = ArrayList()
//    var newestArticleUrl = ""
//        set(value) {
//            field = value
//            sendUpdateEvent()
//        }
//}
//class BaeldungNewsletter {
//    val newestArticleObservers = mutableListOf<(String) -> Unit>()
//
//    var newestArticleUrl: String by Delegates.observable("") { _, _, newValue ->
//        newestArticleObservers.forEach { it(newValue) }
//    }
//}
//class BaeldungReader(private var newsletter: BaeldungNewsletter) : IObserver {
//    override fun update() {
//        println("New Baeldung article: ${newsletter.newestArticleUrl}")
//    }
//}
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
     private lateinit var map: GoogleMap
     //lateinit var fusedLocationClient: FusedLocationProviderClient

    val docBuilder: DocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    interface IObserver {
        fun update()
    }

//    public static void checkLocationService(final Fragment fragment, final FusedLocationProviderClient, client, final OnSuccessListener<LocationSettingsResponse>successListener, OnFailureListener failureListener)
//    {
//
//    }
//    interface IObservable {
//        val observers: ArrayList<IObserver>
//
//        fun add(observer: IObserver) {
//            observers.add(observer)
//        }
//
//        fun remove(observer: IObserver) {
//            observers.remove(observer)
//        }
//
//        fun sendUpdateEvent() {
//            observers.forEach { it.update() }
//        }
//    }

//    private static LocationRequest createLocationRequest(){
//        //LogHelper.trace("createLocationRequest")
//    }

    private fun getUrl(latitude: Double, longitude: Double, nearByPlace: String): String {
        // Search for restaurants nearby
       // val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")

        return "https:/ /maps.googleapis.com/maps/api/streetview?parameters\n" //googlePlaceUrl.toString()


/*
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)

        // Search for restaurants in San Francisco
        val gmmIntentUri =
            Uri.parse("geo:37.7749,-122.4194?q=restaurants")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
*********************************************************************************************************
 val googlePlaceUrl = StringBuilder("https://maps/googleapis.com/maps/api/place/nearbysearch/json?")
        googlePlaceUrl.append("location=$latitude,$longitude")
        googlePlaceUrl.append("&radius=$30")
        googlePlaceUrl.append("&keyword=hospital")
        googlePlaceUrl.append("&sensor=true")
        googlePlaceUrl.append("&key=" + "MYKEY")
        Log.d("MapsActivity", "url = $googlePlaceUrl")

 */
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        getUrl(45.4160844,-122.7229328, "Providence Mercantile")
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mapFragment.onResume()
        mapFragment.allowEnterTransitionOverlap
        mapFragment.activity

        //val scope = "World"
       // println("Hello, $scope!")

//        class ExampleFragment : Fragment() {
//
//            override fun onCreateView(
//                inflater: LayoutInflater,
//                container: ViewGroup?,
//                savedInstanceState: Bundle?
//            ): View {
//                // Inflate the layout for this fragment
//                return inflater.inflate(R.layout.example_fragment, container, false)
//            }
//        }

//        if(mapFragment.isRemoving)
//            println("Application is closing!")


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
    private fun startLocationUpdates(){
        print("Starting location updates")
//        if (ActivityCompat.checkSelfPermission(this)) {
//
//        }
//                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
//                LOCATION_PERMISSION_REQUEST_CODE)
//            return
    }
    private fun createLocationRequest() {
        // 1
        //locationRequest = locationRequest
//        // 2
//        locationRequest.interval = 10000
//        // 3
//        locationRequest.fastestInterval = 5000
//        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//
//        val builder = LocationSettingsRequest.Builder()
//            .addLocationRequest(locationRequest)
//
//        // 4
//        val client = LocationServices.getSettingsClient(this)
//        val task = client.checkLocationSettings(builder.build())
//
//        // 5
//        task.addOnSuccessListener {
//            locationUpdateState = true
//            startLocationUpdates()
//        }
//        task.addOnFailureListener { e ->
//            // 6
//            if (e is ResolvableApiException) {
//                // Location settings are not satisfied, but this can be fixed
//                // by showing the user a dialog.
//                try {
//                    // Show the dialog by calling startResolutionForResult(),
//                    // and check the result in onActivityResult().
//                    e.startResolutionForResult(this@MapsActivity,
//                        REQUEST_CHECK_SETTINGS)
//                } catch (sendEx: IntentSender.SendIntentException) {
//                    // Ignore the error.
//                }
//            }
//        }
    }

    // Setting up a spring animation to animate the view1 and view2 translationX and translationY properties
//    val (anim1X, anim1Y) = findViewById<View>(R.id.view1).let { view1 ->
//        SpringAnimation(view1, DynamicAnimation.TRANSLATION_X) to
//                SpringAnimation(view1, DynamicAnimation.TRANSLATION_Y)
//    }
//    val (anim2X, anim2Y) = findViewById<View>(R.id.view2).let { view2 ->
//        SpringAnimation(view2, DynamicAnimation.TRANSLATION_X) to
//                SpringAnimation(view2, DynamicAnimation.TRANSLATION_Y)
//    }
//
//// Registering the update listener
//    anim1X.addUpdateListener { _, value, _ ->
//        // Overriding the method to notify view2 about the change in the view1’s property.
//        anim2X.animateToFinalPosition(value)
//    }
//
//    anim1Y.addUpdateListener { _, value, _ -> anim2Y.animateToFinalPosition(value) }

    override fun onMapReady(googleMap: GoogleMap) {

        lateinit var map: GoogleMap


        // Add a marker for each hospital
        val milanHospital = LatLng(42.0880786,6.6409324)
	    val salvatorMundiInternationalHosptial= LatLng(42.0554577,6.5969871)
        val josUniversityTeachingHospital = LatLng(8.1603427,3.8807593)
        val stJohnsHealth = LatLng(45.4160609,-122.7229228)
        val memorialHospitalOfSweetwaterCounty = LatLng(45.4160568,-122.7229396)
        val memorialHospitalofConverseCounty = LatLng(45.4159997,-122.7229728)
        val wyomingMedicalCenter = LatLng(45.415987,-122.7229989)
        val rileyHospitalForChildren = LatLng(45.416043,-122.7229752)
        val penRoseHospital = LatLng(45.4160656,-122.7229924)
        val providenceBridgeport = LatLng(45.39, -122.75)
        val dignityHealth = LatLng(44.26, -121.28)
        val evanstonRegionalHospital = LatLng(41.2431244,-115.4730433)
        val providenceMercantile = LatLng(45.42, -122.72)
        val providenceStVincent = LatLng(45.46, -122.792)
        val oregonHealthAndScienceUniversity = LatLng(45.48, -122.81)
        val universityOfWashingtonMedicalCenter = LatLng(46.53, -123.75)
        val providenceWilametteFallsMedicalCenter = LatLng(45.42, -122.72)
        val johnHopkinsHospital = LatLng(39.3299013,-76.6227064)
        val legacygoodSamaritan = LatLng(45.42, -122.85)
        val pioneerMemorialHospital = LatLng(44.83, -120.76)
        val providenceCanbyMedicalPlaza = LatLng(45.42, -122.72)
        val legacyMeridianParkMedicalCenter = LatLng(45.42, -122.72)
        val providenceMedicalPlazaSherwood = LatLng(45.42, -122.72)
        val providenceNewbergMedicalCenter = LatLng(45.36, -122.97)
        val oregonClinicSouth = LatLng(45.42, -122.72)
        val clackamasPediatricClinic = LatLng(45.44, -122.80)
        val providenceMedicalGroupBeaverton = LatLng(45.42, -122.72)
        val legacyEmanuelMedicalCenter = LatLng(45.42, -122.72)
        val bostonUniversityHospital = LatLng(45.4160844,-122.7229328)
        val providenceMilwaukieHospital = LatLng(45.45, -123.06)
        val providenceHoodRiver = LatLng(45.56, -122.69)
        val shrinersHospitalsForChildrenQuebec = LatLng(45.4716222,-73.6035359)
        val notreDameHospitalCcsmtlHeadOffice = LatLng(45.4650333,-73.667449)
        val peakMedicalNorthwestIncorporated = LatLng(45.42, -122.74)
        val legacyMountHoodMedicalCenter = LatLng(45.42, -122.72)
        val oregonStateHospital = LatLng(45.42, -122.72)
        val legacySilverton = LatLng(45.42, -122.72)
        val samaritanNorthLincolnHospital = LatLng(45.42, -122.72)
        val tualityCommunityHospital = LatLng(45.42, -122.72)
        val kaiserPermanenteWestsideMedicalCenter = LatLng(45.49, -122.92)
        val providenceCentrailiaHospital = LatLng(45.42, -122.72)
        val stJoesphMedicalClinic = LatLng(45.42, -122.72)
        val samaritanAlbanyGeneralHospital = LatLng(44.63, 123.12)
        val asanteThreeRiversMedicalCenter = LatLng(45.42, -122.72)
        val blueMountainHospital = LatLng(44.42, -118.96)
        val goodShepardHealthCareSystem = LatLng(45.42, -122.72)
        val vaPortlandHealthCareSystem = LatLng(45.48, -122.69)
        val oregonClinicCardiology = LatLng(45.42, -122.72)
        val huntingtonHospital = LatLng(44.26, -121.28)
        val legacySalmonCreek = LatLng(45.42, -122.72)
        val stCharlesMedicalCenter = LatLng(45.42, -122.72)
        val goodSamaritanRegionalMedicalCenter = LatLng(45.42, -122.72)
        val ProvidenceMedicalCenterMedford = LatLng(45.4160126, -122.7230276)
        val skyLakesMedicalCenter = LatLng(45.42, -122.72)
        val lakeDistrictMedicalCenter = LatLng(45.42, -122.72)
        val samariatanLebanonCommunityHospital = LatLng(44.55, 122.91)
        val peaceHealthPeaceHarborMedicalCenter = LatLng(45.42, -122.72)
        val sacredHeartMedicalCenterUniversityDistrict = LatLng(45.42, -122.72)
        val grandeRondeHospital = LatLng(45.32, -118.11)
        val providenceSwindellsResourceCenter = LatLng(45.42, -122.73)
        val salemHealthHospital = LatLng(45.22, -123.08)
        val stAlphonsusMedicalCenter = LatLng(45.42, -122.72)
        val harneyDistrictHospital = LatLng(44.59, -123.27)
        val columbiaMemorialHospital = LatLng(45.42, -122.72)
        val southernCoosHospitalandHealthCenter = LatLng(45.42, -122.72)
        val woodlandParkHospital = LatLng(38.97, -105.08)
        val curryGeneralHospital = LatLng(45.42, -122.72)
        val coquilleValleyHospital = LatLng(45.42, -122.72)
        val mcKenzieWillametteMedicalCenter = LatLng(45.42, -122.72)
        val midColumbiaMedicalCenterEmergencyRoom = LatLng(45.42, -122.72)
        val adventistHealthTillamook = LatLng(45.42, -122.72)
        val westValleyHospital = LatLng(45.42, -122.72)
        val veteransAffairsMedicalCenterOregon = LatLng(45.42, -122.72)
        val cottageGroveCommunityMedicalCenter = LatLng(45.42, -122.72)
        val stAnthonyHospital = LatLng(45.42, -122.72)
        val adventistHealthPortland = LatLng(45.42, -122.72)
        val eastMorelandHospital = LatLng(45.47, -122.64)
        val palestineHospital = LatLng(31.9508871,-96.005480)
        val bayAreaHospital = LatLng(45.42, -122.72)
        val redmondClinic = LatLng(44.26, -121.28)
        val sageViewPsychiatrists = LatLng(44.07, -121.41)
        val centralWashingtonHosptial = LatLng(47.21, -125.11)
        val providenceStMaryMedicalCenterWallaWalla = LatLng(46.75, -123.56)
        val columbiaBasinHosptial = LatLng(47.04, -125.12)
        val providenceMountCarmelHospital = LatLng(46.86, -125.12)
        val harrisonMedicalCenter = LatLng(46.46, -125.39)
        val sacredHeartChildrensHosptial = LatLng(47.63, -120.39)
        val graysHarborCommunityHospital = LatLng(45.95, -127.36)
        val providenceStPeterHospitalOlympia = LatLng(47.05, -127.33)
        val sacredHeartChildrenHospitalSpokane = LatLng(46.43, -123.02)
        val uwMedicalCenterNorthwestSeattleHospital = LatLng(47.02, -123.66)
        val multiCareGoodSamaritanHospital = LatLng(47.02, -122.88)
        val easternStateHospital = LatLng(45.66, -127.99)
        val westernStateHospital = LatLng(47.18, -127.05)
        val snoqualmieValleyHospital = LatLng(47.00, -123.62)
        val multiCareTacomaGeneralHospital = LatLng(47.40, -123.13)
        val navalHospital = LatLng(46.98, -123.99)
        val highlineMedicalCenter = LatLng(46.98, -123.99)
        val skylineHealth = LatLng(45.86, -123.90)
        val masonGeneralHospital = LatLng(46.95, -125.05)
        val daytonGeneralHospital = LatLng(46.92, -123.10)
        val whitmanHospitalAndMedicalClinics = LatLng(46.87, -119.62)
        val triStateMemorialHospitalAndMedicalCampus = LatLng(46.60, -117.75)
        val mayersMemorialHospital = LatLng(43.43, -130.59)
        val stJoesphsMedicalCenter = LatLng(44.26, -121.28)
        val diginityHealthStRoseDominicanHospital = LatLng(44.26, -121.28)
        val southernHillsHospitalAndMedicalCenter = LatLng(36.10, -117.54)
        val northVistaHospital = LatLng(36.20, -117.40)
        val mountGrantGeneralHospital = LatLng(38.0, -126.31)
        val pershingGeneralHospital = LatLng(37.35, -126.32)
        val sunriseHospitalMedicalCenter = LatLng(36.70, -126.32)
        val northEasternNevadaRegionalHosptital = LatLng(44.26, -121.28)
        val carsonTahoeRegionalMedicalCenter = LatLng(44.26, -121.28)
        val hendersonHospital = LatLng(44.26, -121.28)
        val boulderCityHospital = LatLng(40.03, -122.60)
        val renownRegionalMedicalCenter = LatLng(44.26, -121.28)
        val mikeOcallaghanMilitaryMedicalCenter = LatLng(36.2457836, -115.1)
        val springValleyHospitalMedicalCenter = LatLng(40.61, -127.75)
        val mesaViewRegionalHospital = LatLng(44.26, -121.28)
        val utahStateHospital = LatLng(41.56,-120.97)
        val shrinersHospitalsForChildrenSaltLakeCity = LatLng(42.35,-121.08)
        val cacheValleyHospital = LatLng(42.5187368,-121.0647758)
        val ldsHospital = LatLng(42.3501746,-121.0939713)
        val timpanogosRegionalHospital = LatLng(42.2008855,-121.0111058)
        val parkCityHospital = LatLng(40.4956895,-111.9383514)
        val davisHospitalAndMedicalCenter = LatLng(40.9975814,-112.1011331)
        val mcKayDeeHospital = LatLng(41.1100, 111.5715)
        val ucHealthGrandViewHospital = LatLng(39.60,-108.51)
        val encompassHealthRehabilitationHospital = LatLng(39.5952669,-108.5093332)
        val stFrancisMedicalCenter = LatLng(39.5521225,-108.5094666)
        val theWomensHospitalOfTexas = LatLng(32.9620665,-103.7423977)
        val texasHealthMedicalHearthMethodistHospital = LatLng(34.1545167,-101.5626582)
        val texasMedicalCenter = LatLng(39.3299013,-76.6227064)
        val texasOrthopedicHospital = LatLng(32.9620665,-103.7423977)
        val iraanGeneralHospital = LatLng(32.9620665,-103.7423977)
        val baylorScottAndWhiteMedicalCenter = LatLng(30.4422841,-109.9256475)
        val reevesCountyHospitalDistrict = LatLng(33.105864,-107.6982278)
        val texasHealthHarrisMethodistHospital = LatLng(32.8196653,-103.7431051)
        val texasHealthPresbyterianHospitalDenton = LatLng(33.7563847,-103.4794332)
        val universityOfUtahHospital = LatLng(43.2158724,-121.7791681)
        val medicalCenterOfOdessa = LatLng(31.8438456,-104.8752377)
        val theWomansHospitalOfTexasPediatrics = LatLng(28.3151712,-103.0696408)
        val headacheAndMigraneTreatmentCenter = LatLng(45.4168815,-122.7236538)
        val herberValleyHospital = LatLng(45.4160704,-122.7229424)
        val shrinersSaltLakeCity = LatLng(45.416029,-122.7229606)
        val brighamCityCommunityHospital = LatLng(45.4160255,-122.7230086)
        val utSouthwesternMedicalSchool = LatLng(32.8159489,-96.8477666)
        val childrenMedicalCenterDallas = LatLng(32.8087663,-96.8412482)
        val baylorScottMedical = LatLng(45.4160431,-122.7230584)
        val firstTexasHospitalCyFair = LatLng(36.5292898,-127.1325503)
        val memorialHermannTexasMedicalCenter = LatLng(29.7048122,-95.4173518)
        val scottishRiteForChildren = LatLng(32.8021236,-96.8163139)
        val hcaHoustonMainland = LatLng(45.4474965,-122.7386516)
        val bostonUniversityMedicalCenter = LatLng(42.3474618,-71.1208845)
        val setonMedicalCenterHarkerHeights = LatLng(32.2215139,-98.8221159)
        val memorialHospitalOfTexasCounty = LatLng(32.8011548,-103.7446915)
        val nellJRedfieldMemorialHospital = LatLng(43.393482,-121.8445067)
        val benewahCommunityHospital = LatLng(46.2976093,-124.1433382)
        val weiserMemorialHospital = LatLng(45.4160684,-122.7229575)
        val minidokaMemorialHospital = LatLng(43.8637729,-123.0177321)
        val christusSantaRosaHospitalWestoverHills = LatLng(28.5893737,-101.1299454)
        val texasChildrensHospital = LatLng(28.5893737,-101.1299454)
        val surgicalHospitalOfOkhlahoma = LatLng(39.2089561,-128.0783334)
        val mercyHospitalOkhlahomaCity = LatLng(35.493318,-97.6409485)
        val curaHealth = LatLng(35.4931561,-97.6409498)
        val communityHospitalNorth = LatLng(35.4931561,-97.6409498)
        val oklahomaHeartHospitalHeart = LatLng(38.979045,-128.6869605)
        val westTennesseeHealthcareVolunteer = LatLng(35.6115483,-91.4767948)
        val universityOfTennesseeMedicalCenter = LatLng(35.6115483,-91.2752639)
        val leBonheurChildrensHospital = LatLng(35.6115483,-91.4764742)
        val vanderbiltWilsonCountyHospital = LatLng(35.6115483,-91.4764742)
        val jacksonMadisonCountyGeneralHospital = LatLng(45.4160573,-122.7229612)
        val cumberlandMedicalHospital =  LatLng(45.4160573,-122.7229612)
        val westTennesseeHospital = LatLng(37.8891789,-123.7167999)
        val sentaraVirginiaBeachGeneralHospital = LatLng(45.4159953,-122.7229961)
        val senataraPrincessAnneHospital = LatLng(45.4160653,-122.7229121)
        val virginiaHospitalCenter = LatLng(45.4160653,-122.7229121)
        val naturalMedicineUniversity = LatLng(45.4934574,-122.807967)
        val bonSecoursRichmondCommunityHosptial = LatLng(35.8205637,-135.810595)
        val ascensionStThomasHospital = LatLng(45.41557,-122.7313178)
        val eastTennesseeHospital = LatLng(45.416067,-122.7229058)
        val nashvilleGeneralHospital = LatLng(45.416067,-122.7229058)
        val iuHealthUniversity = LatLng(45.416043,-122.7229752)
        val kingsCollegeHospital = LatLng(45.4160732,-122.7229641)
        val canadianSpecialistHospital = LatLng(45.4160732,-122.7229641)
        val medeor247HospitalDubaiConsulatesArea = LatLng(45.4512965,-122.7818506)
        val freseniusMedicalCareAtLegacyGoodSamaritanHospital = LatLng(45.416055,-122.7229539)
        val kindredHospitalIndianapolis = LatLng(42.2614601,-122.4086393)
        val mbfJbrHospital = LatLng(45.4160732,-122.7229641)
        val thumbayHospitalDubai = LatLng(45.4160732,-122.7223333339641)
        val alZahraHospital = LatLng(45.4160732,-122.7229641)
        val nmcRoyalHospital = LatLng(45.4160732,-122.7229641)
        val drSulaimanAlHabibHospitalInDubai = LatLng(45.4160732,-122.7229641)
        val mediclinicCityHospitalNorthWing = LatLng(45.4160732,-122.7229641)
        val emiratesHospitalJumeriahBeach = LatLng(45.4160732,-122.7229641)
        val gargashHospitalInDubai = LatLng(45.4160732,-122.7229641)
        val peakMedicalNorthwest = LatLng(45.4166679,-122.7268154)
        val providenceExpressCareKruseWay = LatLng(45.4171074,-122.7262975)
        val newHampshireHospital = LatLng(43.821318,-72.6407463)
        val newLondonHospital = LatLng(43.8103583,-72.640777)
        val brighamAndWomensHospital = LatLng(45.5441086,-122.4198746)
        val newEnglandBaptistHospital = LatLng(45.4160577,-122.7229065)
        val floatingHospitalForChildrenHospital = LatLng(45.5054205,-122.4375266)
        val jebelAliHospital = LatLng(45.4160461,-122.7229256)
        val massachusettsGeneralHospital = LatLng(45.4160544,-122.7229401)
        val shrinersHospitalForChildrenBoston = LatLng(36.884958,-132.6318486)
        val massachusettsInstiuteofTechnologyMedicalCenterPediatrics = LatLng(42.3361037,-71.1588672)
//https://maps.googleapis.com/maps/api/streetview?size=400x400&location=47.5763831,-122.4211769
//&fov=80&heading=70&pitch=0
//&key=YOUR_API_KEY&signature=YOUR_SIGNATURE

//
//        private class YourImageAnalyzer : ImageAnalysis.Analyzer {
//
//            override fun analyze(imageProxy: ImageProxy) {
//                val mediaImage = imageProxy.image
//                if (mediaImage != null) {
//                    val image = InputImage.fromMediaImage(mediaImage, imageP//                    // ...//                    // Pass image to an ML Kit Vision APIroxy.imageInfo.rotationDegrees)
//                }
//            }
//        }

        map.addMarker(
            MarkerOptions().position(palestineHospital).title("Palestine Regional Medical Center")

        )
        map.addMarker(
            MarkerOptions().position(evanstonRegionalHospital).title("Evanston Regional Hospital")
        )

        map.addMarker(
            MarkerOptions().position(stJohnsHealth).title("St. John's Health")

        )
        map.addMarker(
            MarkerOptions().position(memorialHospitalOfSweetwaterCounty).title("Memorial Hospital of Sweetwater County")

        )
        map.addMarker(
            MarkerOptions().position(memorialHospitalofConverseCounty).title("Memorial Hospital of Converse County")
        )
        map.addMarker(
            MarkerOptions().position(wyomingMedicalCenter).title("WyomingMedicalCenter")
        )
        map.addMarker(
            MarkerOptions().position(massachusettsGeneralHospital).title("Massachusetts General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(massachusettsInstiuteofTechnologyMedicalCenterPediatrics).title("Massachusetts Instiute of Technology Medical Center Pediatrics")
        )
        map.addMarker(
            MarkerOptions().position(floatingHospitalForChildrenHospital).title("Floating Hospital For Children Hospital")
        )
        map.addMarker(
            MarkerOptions().position(bostonUniversityMedicalCenter).title("Boston University Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(bostonUniversityHospital).title("Boston University Hospital")
        )
        map.addMarker(
            MarkerOptions().position(brighamAndWomensHospital).title("Brigham And Womens Hospital")
        )
        map.addMarker(
            MarkerOptions().position(newEnglandBaptistHospital).title("Shriners Hospital For Children Boston")
        )
        map.addMarker(
            MarkerOptions().position(shrinersHospitalForChildrenBoston).title("Shriners Hospital For Children Boston")
        )
        map.addMarker(
            MarkerOptions().position(newLondonHospital).title("New London Hospital")
        )
        map.addMarker(
            MarkerOptions().position(newHampshireHospital).title("New Hampshire Hospital")
        )
        map.addMarker(

                MarkerOptions().position(peakMedicalNorthwest).title("Peak Medical Northwest")
        )
        map.addMarker(

            MarkerOptions().position(providenceExpressCareKruseWay).title("Providence Express Care Kruse Way")
        )
        map.addMarker(

            MarkerOptions().position(gargashHospitalInDubai).title("Gargash Hospital In Dubai")
        )
        map.addMarker(

            MarkerOptions().position(drSulaimanAlHabibHospitalInDubai).title("Dr Sulaiman Al Habib Hospital In Dubai")
        )

        map.addMarker(

            MarkerOptions().position(nmcRoyalHospital).title("NMC Royal Hospital City Hospital North Wing")
        )

        map.addMarker(

            MarkerOptions().position(mediclinicCityHospitalNorthWing).title("Mediclinic City Hospital North Wing")
        )

        map.addMarker(

            MarkerOptions().position(alZahraHospital).title("Al Zahra Hospital")
        )

        map.addMarker(

            MarkerOptions().position(thumbayHospitalDubai).title("Thumbay Hospital Dubai")
        )

        map.addMarker(

            MarkerOptions().position(bonSecoursRichmondCommunityHosptial).title("Bon Secours Richmond Community Hosptial")
        )

        map.addMarker(

            MarkerOptions().position(emiratesHospitalJumeriahBeach).title("Emirates Hospital Jumeriah Beach")
        )
        map.addMarker(

            MarkerOptions().position(mbfJbrHospital).title("MBF JBR Hospital")
        )
        map.addMarker(

            MarkerOptions().position(canadianSpecialistHospital).title("Canadian Specialist Hospital")
        )
        map.addMarker(

            MarkerOptions().position(medeor247HospitalDubaiConsulatesArea).title("Fresenius Medical Care At Hospital")
        )
        map.addMarker(

            MarkerOptions().position(freseniusMedicalCareAtLegacyGoodSamaritanHospital).title("Fresenius Medical Care At Legacy Good Samaritan Hospital")
        )
        map.addMarker(

            MarkerOptions().position(kingsCollegeHospital).title("Kings College Hospital")
        )
        map.addMarker(

            MarkerOptions().position(kindredHospitalIndianapolis).title("Kindred Hospital Indianapolis")
        )
        map.addMarker(

            MarkerOptions().position(nashvilleGeneralHospital).title("Nashville General Hospital")
        )
        map.addMarker(

            MarkerOptions().position(rileyHospitalForChildren).title("rileyHospitalForChildren")
        )
        map.addMarker(

            MarkerOptions().position(iuHealthUniversity).title("IU Health Hospital Hospital")
        )
        map.addMarker(

            MarkerOptions().position(sentaraVirginiaBeachGeneralHospital).title("Sentara Virginia Beach General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(westTennesseeHealthcareVolunteer).title("West Tennessee Healthcare Volunteer")
        )
        map.addMarker(
            MarkerOptions().position(eastTennesseeHospital).title("eastTennesseeHospital")
        )
        map.addMarker(

            MarkerOptions().position(ascensionStThomasHospital).title("Ascension St. Thomas Hospital")
        )
        map.addMarker(
           MarkerOptions().position(naturalMedicineUniversity).title("Natural Medicine University")
        )

        map.addMarker(
            MarkerOptions().position(virginiaHospitalCenter).title("Virginia Hospital Center")
        )

        map.addMarker(
            MarkerOptions().position(westTennesseeHospital).title("West Tennessee Hospital")
        )
        map.addMarker(
            MarkerOptions().position(cumberlandMedicalHospital).title("Cumberland Medical Hospital")
        )
        map.addMarker(
            MarkerOptions().position(jacksonMadisonCountyGeneralHospital).title("Jackson Madison County General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(leBonheurChildrensHospital).title("Le Bonheur Children's Hospital")
        )
        map.addMarker(
            MarkerOptions().position(vanderbiltWilsonCountyHospital).title("Vanderbilt Wilson County Hospital")
        )
        map.addMarker(
            MarkerOptions().position(universityOfTennesseeMedicalCenter).title("West Tennessee Healthcare Volunteer")
        )
        map.addMarker(
            MarkerOptions().position(senataraPrincessAnneHospital).title("sentara Princess Anne Hospital")
        )
        map.addMarker(
            MarkerOptions().position(oklahomaHeartHospitalHeart).title("Oklahoma Heart Hospital")
        )
        map.addMarker(
            MarkerOptions().position(curaHealth).title("Curahealth")
        )
        map.addMarker(
            MarkerOptions().position(communityHospitalNorth).title("Community Hospital North")
        )
        map.addMarker(
            MarkerOptions().position(surgicalHospitalOfOkhlahoma).title("Surgical Hospital Of Okhlahoma")
        )
        map.addMarker(
            MarkerOptions().position(mercyHospitalOkhlahomaCity).title("Mercy Hospital of Okhlahoma City")
        )
        map.addMarker(
            MarkerOptions().position(christusSantaRosaHospitalWestoverHills).title("Christus Santa Rosa Hospital Westover Hills")
        )

        map.addMarker(
            MarkerOptions().position(texasChildrensHospital).title("Texas Children's Hospital")
        )
        map.addMarker(
            MarkerOptions().position(benewahCommunityHospital).title("Benewah Community Hospital")
        )
        map.addMarker(
            MarkerOptions().position(minidokaMemorialHospital).title("Minidoka Memorial Hospital")
        )
        map.addMarker(
            MarkerOptions().position(weiserMemorialHospital).title("Weiser Memorial Hospital")
        )
        map.addMarker(
            MarkerOptions().position(nellJRedfieldMemorialHospital).title("Nell J. Redfield Memorial Hospital")
        )
        map.addMarker(
            MarkerOptions().position(memorialHospitalOfTexasCounty).title("Seton Medical Center Harker Heights")
        )
        map.addMarker(
            MarkerOptions().position(hcaHoustonMainland).title("HCA Houston Mainland")
        )
        map.addMarker(
            MarkerOptions().position(setonMedicalCenterHarkerHeights).title("Seton Medical Center Harker Heights")
        )
        map.addMarker(
            MarkerOptions().position(memorialHermannTexasMedicalCenter).title("Memorial Hermann Texas Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(scottishRiteForChildren).title("Scottish Rite For Children")
        )
        map.addMarker(
            MarkerOptions().position(firstTexasHospitalCyFair).title("First Texas Hospital CyFair")
        )
        map.addMarker(
            MarkerOptions().position(baylorScottMedical).title("Baylor Scott")
        )
        map.addMarker(
            MarkerOptions().position(utSouthwesternMedicalSchool).title("utSouthwesternMedicalSchool")
        )
        map.addMarker(
            MarkerOptions().position(childrenMedicalCenterDallas).title("Children's Medical Center Dallas")
        )
        map.addMarker(
            MarkerOptions().position(shrinersSaltLakeCity).title("Shriners Salt Lake City")
        )
        map.addMarker(
            MarkerOptions().position(herberValleyHospital).title("Herber Valley Hospital")
        )

//        mHerberValleyHospital.setTag(0)
        map.addMarker(
            MarkerOptions().position(headacheAndMigraneTreatmentCenter).title("Headache and Migrane Treatment Center")
        )
        map.addMarker(
            MarkerOptions().position(theWomansHospitalOfTexasPediatrics).title("Memorial Hospital Of Texas County")
        )
        map.addMarker(
            MarkerOptions().position(memorialHospitalOfTexasCounty).title("Memorial Hospital Of Texas County")
        )
        map.addMarker(
            MarkerOptions().position(medicalCenterOfOdessa).title("Medical Center of Odessa")
        )
        map.addMarker(
            MarkerOptions().position(universityOfUtahHospital).title("University Of Utah Hospital")
        )
        map.addMarker(
            MarkerOptions().position(texasHealthPresbyterianHospitalDenton).title("Texas Health Presbyterian Hospital Denton")
        )
        map.addMarker(
            MarkerOptions().position(texasHealthHarrisMethodistHospital).title("Texas Health Harris Methodist Hospital")
        )
        map.addMarker(
            MarkerOptions().position(texasHealthMedicalHearthMethodistHospital).title("Texas Health Medical Hearth Methodist Hospital")
        )
//        map.addMarker(
//            MarkerOptions().position(hcaHoustonHealthcareMainland).title("HCA Houston Healthcare Mainland")
//        )
        map.addMarker(
            MarkerOptions().position(baylorScottAndWhiteMedicalCenter).title("Baylor Scott and White Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(reevesCountyHospitalDistrict).title("Reeves County Hospital District")
        )
        map.addMarker(
            MarkerOptions().position(texasMedicalCenter).title("Texas Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(iraanGeneralHospital).title("Iraan General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(texasOrthopedicHospital).title("Texas Orthopedic Hospital")
        )
        map.addMarker(
            MarkerOptions().position(johnHopkinsHospital).title("John Hopkins University")
        )
        map.addMarker(
            MarkerOptions().position(texasHealthMedicalHearthMethodistHospital).title("Texas Health Medical Hearth Methodist Hospital")
        )
        map.addMarker(
            MarkerOptions().position(theWomensHospitalOfTexas).title("The women's hospital of Texas")
        )
        map.addMarker(
            MarkerOptions().position(penRoseHospital).title("Penrose Hospitals")
        )
        map.addMarker(
            MarkerOptions().position(stFrancisMedicalCenter).title("Encompass Health Rehabilitation Hospital")
        )
        map.addMarker(
            MarkerOptions().position(encompassHealthRehabilitationHospital).title("Encompass Health Rehabilitation Hospital")
        )

        map.addMarker(
            MarkerOptions().position(ucHealthGrandViewHospital).title("UC Health Grand View Hospital")
        )

        map.addMarker(
            MarkerOptions().position(mcKayDeeHospital).title("McKay Hospital")
        )
        map.addMarker(
            MarkerOptions().position(davisHospitalAndMedicalCenter).title("Davis Hosputal And Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(parkCityHospital).title("Park City Hospital")
        )

        map.addMarker(
            MarkerOptions().position(timpanogosRegionalHospital).title("Timpanogos Regional Hospital")
        )
        map.addMarker(
            MarkerOptions().position(ldsHospital).title("Cache Valley Hospital")
        )
        map.addMarker(
            MarkerOptions().position(cacheValleyHospital).title("Cache Valley Hospital")
        )
        map.addMarker(
            MarkerOptions().position(notreDameHospitalCcsmtlHeadOffice).title("Notre Dame Hospital CCSMTL Head Office")
        )
        map.addMarker(
            MarkerOptions().position(shrinersHospitalsForChildrenSaltLakeCity).title("Shriners Hospitals For Children Salt Lake City")
        )
        map.addMarker(
            MarkerOptions().position(utahStateHospital).title("Utah State Hospital")
        )
        map.addMarker(
            MarkerOptions().position(mesaViewRegionalHospital).title("Mesa View Regional Hospital")
        )
        map.addMarker(
            MarkerOptions().position(springValleyHospitalMedicalCenter)
                .title("Mike O'Callaghan Military Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(boulderCityHospital).title("Boulder City Hospital")
        )

        map.addMarker(
            MarkerOptions().position(mikeOcallaghanMilitaryMedicalCenter)
                .title("Mike O'Callaghan Military Medical Center")
        )

        map.addMarker(
            MarkerOptions().position(renownRegionalMedicalCenter)
                .title("Renown Regional Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(hendersonHospital).title("Henderson Hospital")
        )
        map.addMarker(
            MarkerOptions().position(carsonTahoeRegionalMedicalCenter)
                .title("Carson Tahoe Regional Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(northEasternNevadaRegionalHosptital)
                .title("North Eastern Nevada Regional Hosptital")
        )
        map.addMarker(
            MarkerOptions().position(sunriseHospitalMedicalCenter)
                .title("Sunrise Hospital Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(pershingGeneralHospital).title("Pershing General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(mountGrantGeneralHospital)
                .title("Mount Grant General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(northVistaHospital).title("North Vista Hospital")
        )
        map.addMarker(
            MarkerOptions().position(southernHillsHospitalAndMedicalCenter)
                .title("Southern Hills Hospital and Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(diginityHealthStRoseDominicanHospital).title("Dignity Health")
        )
        map.addMarker(
            MarkerOptions().position(stJoesphsMedicalCenter).title("St. Joesph's Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(huntingtonHospital).title("Huntington Hospital")
        )
        map.addMarker(
            MarkerOptions().position(dignityHealth).title("Dignity Health")
        )
        map.addMarker(
            MarkerOptions().position(mayersMemorialHospital).title("Mayers Memoriral Hospital")
        )
        map.addMarker(
            MarkerOptions().position(whitmanHospitalAndMedicalClinics)
                .title("Whitman Hospital and Medical Clinics")
        )
        map.addMarker(
            MarkerOptions().position(triStateMemorialHospitalAndMedicalCampus)
                .title("Tristate Memorial Hospital and Medical Campus")
        )
        map.addMarker(
            MarkerOptions().position(daytonGeneralHospital).title("Dayton General Hosptial")
        )
        map.addMarker(
            MarkerOptions().position(masonGeneralHospital).title("Mason General Health")
        )
        map.addMarker(
            MarkerOptions().position(skylineHealth).title("Skyline Health")
        )
        map.addMarker(
            MarkerOptions().position(highlineMedicalCenter).title("Highline Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(navalHospital).title("Naval Hospital")
        )
        map.addMarker(
            MarkerOptions().position(multiCareTacomaGeneralHospital)
                .title("MultiCare Tacoma General Hospital")
        )

        map.addMarker(
            MarkerOptions().position(snoqualmieValleyHospital).title("Snoqualmie Valley Hospital")
        )
        map.addMarker(
            MarkerOptions().position(westernStateHospital).title("Western State Hospital")
        )
        map.addMarker(
            MarkerOptions().position(easternStateHospital).title("Eastern State Hosital")
        )
        map.addMarker(
            MarkerOptions().position(multiCareGoodSamaritanHospital)
                .title("MultiCare Good Samaritan")
        )
        map.addMarker(
            MarkerOptions().position(uwMedicalCenterNorthwestSeattleHospital)
                .title("UW Medical Center Northwest Seattle Hospital")
        )
        map.addMarker(
            MarkerOptions().position(sacredHeartChildrenHospitalSpokane)
                .title("Sacred Heart Hospital Spokane")
        )
        map.addMarker(
            MarkerOptions().position(providenceStPeterHospitalOlympia)
                .title("Providence St. Peter Hosptial Olympia")
        )
        map.addMarker(
            MarkerOptions().position(graysHarborCommunityHospital).title("Gray's Harbor Community")
        )
        map.addMarker(
            MarkerOptions().position(sacredHeartChildrensHosptial)
                .title("Sacred Heart Children's Hospital")
        )
        map.addMarker(
            MarkerOptions().position(harrisonMedicalCenter).title("Harrison Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(providenceMountCarmelHospital)
                .title("Providence Mount Carmel Hospital")
        )
        map.addMarker(
            MarkerOptions().position(columbiaBasinHosptial).title("Columbia Basin Hospital")
        )
        map.addMarker(
            MarkerOptions().position(providenceStMaryMedicalCenterWallaWalla)
                .title("Providence St.Mary Medical Center Walla Walla")
        )
        map.addMarker(
            MarkerOptions().position(centralWashingtonHosptial).title("Central Washington Hospital")
        )
        map.addMarker(
            MarkerOptions().position(pioneerMemorialHospital).title("Pioneer Memorial Hosiptal")
        )
        map.addMarker(
            MarkerOptions().position(sageViewPsychiatrists).title("Sage View Psychiatrists")
        )

        map.addMarker(
            MarkerOptions().position(redmondClinic).title("Redmond Clinic")
        )
        map.addMarker(
            MarkerOptions().position(bayAreaHospital).title("Bay Area Hospital")
        )
        map.addMarker(
            MarkerOptions().position(eastMorelandHospital).title("East Moreland Hospital")
        )
        map.addMarker(
            MarkerOptions().position(legacyMountHoodMedicalCenter).title("Legacy Mount Hood")
        )
        map.addMarker(
            MarkerOptions().position(adventistHealthPortland).title("Adventist Health Portland")
        )
        map.addMarker(
            MarkerOptions().position(stAnthonyHospital).title("St. Anthony Hospital ")
        )
        map.addMarker(
            MarkerOptions().position(cottageGroveCommunityMedicalCenter)
                .title("Cottage Grove Community Medical Center")
        )

        map.addMarker(
            MarkerOptions().position(veteransAffairsMedicalCenterOregon)
                .title("Veterans Affairs Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(westValleyHospital).title("West Valley Hospital")
        )
        map.addMarker(
            MarkerOptions().position(adventistHealthTillamook).title("Adventist Health Center")
        )
        map.addMarker(
            MarkerOptions().position(midColumbiaMedicalCenterEmergencyRoom)
                .title("Mid Columbia Medical Center Emergency Room")
        )
        map.addMarker(
            MarkerOptions().position(mcKenzieWillametteMedicalCenter)
                .title("McKenzie Willamette Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(coquilleValleyHospital).title("Coquille Valley Hospital")
        )
        map.addMarker(
            MarkerOptions().position(curryGeneralHospital).title("Curry General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(woodlandParkHospital).title("Woodland Park Hospital")
        )
        map.addMarker(
            MarkerOptions().position(legacyEmanuelMedicalCenter)
                .title("Legacy Emanuel Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(southernCoosHospitalandHealthCenter)
                .title("Southern Coos Hospital and Health Center")
        )
        map.addMarker(
            MarkerOptions().position(columbiaMemorialHospital).title("Columbia Memorial Hospital")
        )
        map.addMarker(
            MarkerOptions().position(harneyDistrictHospital).title("Harney District Hospital")
        )
        map.addMarker(
            MarkerOptions().position(stAlphonsusMedicalCenter).title("St. Alphonsus Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(salemHealthHospital).title("Salem Health Hospital")
        )
        map.addMarker(
            MarkerOptions().position(providenceSwindellsResourceCenter)
                .title("Providence Swindells Resource Center")
        )
        map.addMarker(
            MarkerOptions().position(grandeRondeHospital).title("Grande Ronde Hospital")
        )
        map.addMarker(
            MarkerOptions().position(sacredHeartMedicalCenterUniversityDistrict)
                .title("Sacred Heart Medical Center University District")
        )
        map.addMarker(
            MarkerOptions().position(peaceHealthPeaceHarborMedicalCenter)
                .title("Peace Health Peace Harbor Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(samariatanLebanonCommunityHospital)
                .title("Samariatan Lebanon Community Hospital")
        )

        map.addMarker(
            MarkerOptions().position(lakeDistrictMedicalCenter).title("Lake District Hospital")
        )
        map.addMarker(
            MarkerOptions().position(skyLakesMedicalCenter)
                .title("Sky Lakes medical center Klamath Falls")
        )
        map.addMarker(
            MarkerOptions().position(ProvidenceMedicalCenterMedford)
                .title("Providence Medical Center Medford ")
        )
        map.addMarker(
            MarkerOptions().position(goodSamaritanRegionalMedicalCenter)
                .title("St. Charles Medical Center")
        )

        map.addMarker(
            MarkerOptions().position(stCharlesMedicalCenter).title("St. Charles Medical Center")
        )

        map.addMarker(
            MarkerOptions().position(legacySalmonCreek).title("Legacy Salmon Creek")
        )

        map.addMarker(
            MarkerOptions().position(oregonClinicCardiology).title("Oregon Clinic Cardiology")
        )
        map.addMarker(
            MarkerOptions().position(vaPortlandHealthCareSystem)
                .title("Veteran Affairs Portland Health Care System")
        )
//
        map.addMarker(
            MarkerOptions().position(oregonHealthAndScienceUniversity)
                .title("Oregon Health and Science University")
        )
        map.addMarker(
            MarkerOptions().position(goodShepardHealthCareSystem)
                .title("Good Shepard Health Care System")
        )
        map.addMarker(
            MarkerOptions().position(blueMountainHospital).title("Blue Mountain Hospital")
        )
        map.addMarker(
            MarkerOptions().position(asanteThreeRiversMedicalCenter)
                .title("Asante Three Rivers Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(samaritanAlbanyGeneralHospital)
                .title("Samaritan Albany General Hospital")
        )
        map.addMarker(
            MarkerOptions().position(stJoesphMedicalClinic).title("St. Joesph Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(providenceCentrailiaHospital)
                .title("Providence Centrailia Hospital")
        )
        map.addMarker(
            MarkerOptions().position(kaiserPermanenteWestsideMedicalCenter)
                .title("Kaiser Permanente Westside Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(tualityCommunityHospital).title("Tuality Community Hospital")
        )
        map.addMarker(
            MarkerOptions().position(samaritanNorthLincolnHospital)
                .title("Samartian North Lincoln Hospital")
        )
        map.addMarker(
            MarkerOptions().position(legacySilverton).title("Legacy Silverton Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(oregonStateHospital).title("Oregon State Hospital")
        )
        map.addMarker(
            MarkerOptions().position(peakMedicalNorthwestIncorporated)
                .title("Peak Medical Northwest Incorporated")
        )
        map.addMarker(
            MarkerOptions().position(shrinersHospitalsForChildrenQuebec)
                .title("Shriners Hospital for Children, Quebec")
        )
        map.addMarker(
            MarkerOptions().position(providenceHoodRiver).title("Providence Hood River Hospital")
        )
        map.addMarker(
            MarkerOptions().position(providenceMilwaukieHospital)
                .title("Providence Milwaukie Hospital")
        )
        map.addMarker(
            MarkerOptions().position(providenceMedicalGroupBeaverton)
                .title("Providence Medical Group Beaverton")
        )
        map.addMarker(
            MarkerOptions().position(clackamasPediatricClinic).title("Clackamas Pediatric Clinic")
        )
        map.addMarker(
            MarkerOptions().position(oregonClinicSouth).title("Oregon Clinic South")
        )

        map.addMarker(
            MarkerOptions().position(providenceNewbergMedicalCenter)
                .title("Providence Newberg Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(providenceMedicalPlazaSherwood)
                .title("Providence Medical Plaza Sherwood")
        )
        map.addMarker(
            MarkerOptions().position(legacyMeridianParkMedicalCenter)
                .title("Legacy Meridian Park Medical Plaza")
        )
        map.addMarker(
            MarkerOptions().position(providenceCanbyMedicalPlaza).title("Providence Medical Plaza")
        )
        map.addMarker(
            MarkerOptions().position(providenceWilametteFallsMedicalCenter)
                .title("Providence Wilamette Falls Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(legacygoodSamaritan).title("Legacy Good Samaritan")
        )
        map.addMarker(
            MarkerOptions().position(providenceBridgeport).title("Providence Bridgeport")
        )
        map.addMarker(
            MarkerOptions().position(providenceMercantile).title("Providence Mercantile")
        )

        map.addMarker(
            MarkerOptions().position(providenceStVincent).title("Providence St. Vincent")
        )
        map.addMarker(
            MarkerOptions().position(universityOfWashingtonMedicalCenter)
                .title("University of Washington Medical Center")
        )
        map.addMarker(
            MarkerOptions().position(brighamCityCommunityHospital)
                .title("Brigham City Community Hospital")
        )
        map.moveCamera(CameraUpdateFactory.newLatLng(providenceBridgeport))


        val naturalMedicine:HashMap<String, Int> = HashMap<String, Int>()
        naturalMedicine.put("honey",1)
        //Medicine storage
//        val honey = "Honey"
//        val oliveOil = "Olive Oil"
//        val blackCarawaySeeds = "Black Caraway Seeds"
        //val myArray3 = arrayOf<String>(honey,oliveOil,blackCarawaySeeds)
       // println(Arrays.deepToString(myArray3))

//        for (int i = 0; i < aNums.length; i++) {
//    String strToPrint = "aNums[" + i + "]=" + aNums[i];
//}
        //val numbersMap = map(1)

//drawerToggleDelegate.

//<                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         Fragment medicineFragment = new Fragment
//        val `is` = ImageSpan(context, resId)
//        text.setSpan(`is`, index, index + strLength, 0)
    }

    private lateinit var constraintLayout: ConstraintLayout

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Instantiate an ImageView and define its properties
//        val i = ImageView(this).apply {
//            setImageResource(R.drawable.my_image)
//            contentDescription = resources.getString(R.string.my_image_desc)
//
//            // set the ImageView bounds to match the Drawable's dimensions
//            adjustViewBounds = true
//            layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT)
//        }
//
//        // Create a ConstraintLayout in which to add the ImageView
//        constraintLayout = ConstraintLayout(this).apply {
//
//            // Add the ImageView to the layout.
//            addView(i)
//        }
//
//        // Set the layout as the content view.
//        setContentView(constraintLayout)
//    }
    }

//    fun classifyText(text:String): Int{
//        //val class_1_probability = findProbabilityGivenSample(text, positiveBagOf)
//    }
