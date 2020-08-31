//Abdullah Mutaz Alshawa
//7/8/20
//Hospital Locator
//Locates the directions to hospitals for COVID 19 treatment using the Google Maps API

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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.xml.parsers.DocumentBuilder
import android.widget.Button
import javax.xml.parsers.DocumentBuilderFactory

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
//    }
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
     private lateinit var mMap: GoogleMap

    val docBuilder: DocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    interface IObserver {
        fun update()
    }
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



    private fun getUrl(latitude: Double, longitude: Double, nearByPlace: String): String {
        // Search for restaurants nearby
       // val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")

        return "null" //googlePlaceUrl.toString()


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
//        if (ActivityCompat.checkSelfPermission(this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
//                LOCATION_PERMISSION_REQUEST_CODE)
//            return
    }
    private fun createLocationRequest() {
        // 1
//        locationRequest = LocationRequest()
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

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        // Add a marker for each hospital
        val stJohnsHealth = LatLng(45.4160609,-122.7229228)
        val memorialHospitalOfSweetwaterCounty = LatLng(45.4160568,-122.7229396)
        val memorialHospitalofConverseCounty = LatLng(45.4159997,-122.7229728)
        val wyomingMedicalCenter = LatLng(45.415987,-122.7229989)
        val rileyHospitalForChildren = LatLng(45.416043,-122.7229752)
        val penRoseHospital = LatLng(45.4160656,-122.7229924)
        val providenceBridgeport = LatLng(45.39, -122.75)
        val dignityHealth = LatLng(44.26, -121.28)
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
        val  kingsCollegeHospital = LatLng(45.4160732,-122.7229641)
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
        val massachusettsGeneralHospital = LatLng(45.4160544,-122.7229401)
        val shrinersHospitalForChildrenBoston = LatLng(36.884958,-132.6318486)
        val massachusettsInstiuteofTechnologyMedicalCenterPediatrics = LatLng(42.3361037,-71.1588672)
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
        mMap.addMarker(
            MarkerOptions().position(palestineHospital).title("Palestine Hospital")

        )
        mMap.addMarker(
            MarkerOptions().position(stJohnsHealth).title("St. John's Health")

        )
        mMap.addMarker(
            MarkerOptions().position(stJohnsHealth).title("St. John's Health")

        )
        mMap.addMarker(
            MarkerOptions().position(memorialHospitalOfSweetwaterCounty).title("Memorial Hospital of Sweetwater County")

        )
        mMap.addMarker(
            MarkerOptions().position(memorialHospitalofConverseCounty).title("Memorial Hospital of Converse County")
        )
        mMap.addMarker(
            MarkerOptions().position(wyomingMedicalCenter).title("wyomingMedicalCenter")
        )
        mMap.addMarker(
            MarkerOptions().position(massachusettsGeneralHospital).title("Massachusetts General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(massachusettsInstiuteofTechnologyMedicalCenterPediatrics).title("Massachusetts Instiute of Technology Medical Center Pediatrics")
        )
        mMap.addMarker(
            MarkerOptions().position(floatingHospitalForChildrenHospital).title("Floating Hospital For Children Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(bostonUniversityHospital).title("Boston University Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(brighamAndWomensHospital).title("Brigham And Womens Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(newEnglandBaptistHospital).title("Shriners Hospital For Children Boston")
        )
        mMap.addMarker(
            MarkerOptions().position(shrinersHospitalForChildrenBoston).title("Shriners Hospital For Children Boston")
        )
        mMap.addMarker(
            MarkerOptions().position(newLondonHospital).title("New London Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(newHampshireHospital).title("New Hampshire Hospital")
        )
        mMap.addMarker(

                MarkerOptions().position(peakMedicalNorthwest).title("Peak Medical Northwest")
        )
        mMap.addMarker(

            MarkerOptions().position(providenceExpressCareKruseWay).title("Providence Express Care Kruse Way")
        )
        mMap.addMarker(

            MarkerOptions().position(gargashHospitalInDubai).title("Gargash Hospital In Dubai")
        )
        mMap.addMarker(

            MarkerOptions().position(drSulaimanAlHabibHospitalInDubai).title("Dr Sulaiman Al Habib Hospital In Dubai")
        )

        mMap.addMarker(

            MarkerOptions().position(nmcRoyalHospital).title("NMC Royal Hospital City Hospital North Wing")
        )

        mMap.addMarker(

            MarkerOptions().position(mediclinicCityHospitalNorthWing).title("Mediclinic City Hospital North Wing")
        )

        mMap.addMarker(

            MarkerOptions().position(alZahraHospital).title("Al Zahra Hospital")
        )

        mMap.addMarker(

            MarkerOptions().position(thumbayHospitalDubai).title("Thumbay Hospital Dubai")
        )

        mMap.addMarker(

            MarkerOptions().position(bonSecoursRichmondCommunityHosptial).title("Bon Secours Richmond Community Hosptial")
        )

        mMap.addMarker(

            MarkerOptions().position(emiratesHospitalJumeriahBeach).title("Emirates Hospital Jumeriah Beach")
        )
        mMap.addMarker(

            MarkerOptions().position(mbfJbrHospital).title("MBF JBR Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(canadianSpecialistHospital).title("Canadian Specialist Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(medeor247HospitalDubaiConsulatesArea).title("Fresenius Medical Care At Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(freseniusMedicalCareAtLegacyGoodSamaritanHospital).title("Fresenius Medical Care At Legacy Good Samaritan Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(kingsCollegeHospital).title("Kings College Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(kindredHospitalIndianapolis).title("Kindred Hospital Indianapolis")
        )
        mMap.addMarker(

            MarkerOptions().position(nashvilleGeneralHospital).title("Nashville General Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(rileyHospitalForChildren).title("rileyHospitalForChildren")
        )
        mMap.addMarker(

            MarkerOptions().position(iuHealthUniversity).title("IU Health Hospital Hospital")
        )
        mMap.addMarker(

            MarkerOptions().position(sentaraVirginiaBeachGeneralHospital).title("Sentara Virginia Beach General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(westTennesseeHealthcareVolunteer).title("West Tennessee Healthcare Volunteer")
        )
        mMap.addMarker(
            MarkerOptions().position(eastTennesseeHospital).title("eastTennesseeHospital")
        )
        mMap.addMarker(

            MarkerOptions().position(ascensionStThomasHospital).title("Ascension St. Thomas Hospital")
        )
        mMap.addMarker(
           MarkerOptions().position(naturalMedicineUniversity).title("Natural Medicine University")
        )

        mMap.addMarker(
            MarkerOptions().position(virginiaHospitalCenter).title("Virginia Hospital Center")
        )

        mMap.addMarker(
            MarkerOptions().position(westTennesseeHospital).title("West Tennessee Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(cumberlandMedicalHospital).title("Cumberland Medical Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(jacksonMadisonCountyGeneralHospital).title("Jackson Madison County General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(leBonheurChildrensHospital).title("Le Bonheur Children's Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(vanderbiltWilsonCountyHospital).title("Vanderbilt Wilson County Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(universityOfTennesseeMedicalCenter).title("West Tennessee Healthcare Volunteer")
        )
        mMap.addMarker(
            MarkerOptions().position(senataraPrincessAnneHospital).title("sentara Princess Anne Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(oklahomaHeartHospitalHeart).title("Oklahoma Heart Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(curaHealth).title("Curahealth")
        )
        mMap.addMarker(
            MarkerOptions().position(communityHospitalNorth).title("Community Hospital North")
        )
        mMap.addMarker(
            MarkerOptions().position(surgicalHospitalOfOkhlahoma).title("Surgical Hospital Of Okhlahoma")
        )
        mMap.addMarker(
            MarkerOptions().position(mercyHospitalOkhlahomaCity).title("Mercy Hospital of Okhlahoma City")
        )
        mMap.addMarker(
            MarkerOptions().position(christusSantaRosaHospitalWestoverHills).title("Christus Santa Rosa Hospital Westover Hills")
        )

        mMap.addMarker(
            MarkerOptions().position(texasChildrensHospital).title("Texas Children's Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(benewahCommunityHospital).title("Benewah Community Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(minidokaMemorialHospital).title("Minidoka Memorial Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(weiserMemorialHospital).title("Weiser Memorial Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(nellJRedfieldMemorialHospital).title("Nell J. Redfield Memorial Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(memorialHospitalOfTexasCounty).title("Seton Medical Center Harker Heights")
        )
        mMap.addMarker(
            MarkerOptions().position(hcaHoustonMainland).title("HCA Houston Mainland")
        )
        mMap.addMarker(
            MarkerOptions().position(setonMedicalCenterHarkerHeights).title("Seton Medical Center Harker Heights")
        )
        mMap.addMarker(
            MarkerOptions().position(memorialHermannTexasMedicalCenter).title("Memorial Hermann Texas Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(scottishRiteForChildren).title("Scottish Rite For Children")
        )
        mMap.addMarker(
            MarkerOptions().position(firstTexasHospitalCyFair).title("First Texas Hospital CyFair")
        )
        mMap.addMarker(
            MarkerOptions().position(baylorScottMedical).title("Baylor Scott")
        )
        mMap.addMarker(
            MarkerOptions().position(utSouthwesternMedicalSchool).title("utSouthwesternMedicalSchool")
        )
        mMap.addMarker(
            MarkerOptions().position(childrenMedicalCenterDallas).title("Children's Medical Center Dallas")
        )
        mMap.addMarker(
            MarkerOptions().position(shrinersSaltLakeCity).title("Shriners Salt Lake City")
        )
        mMap.addMarker(
            MarkerOptions().position(herberValleyHospital).title("Herber Valley Hospital")
        )

//        mHerberValleyHospital.setTag(0)
        mMap.addMarker(
            MarkerOptions().position(headacheAndMigraneTreatmentCenter).title("Headache and Migrane Treatment Center")
        )
        mMap.addMarker(
            MarkerOptions().position(theWomansHospitalOfTexasPediatrics).title("Memorial Hospital Of Texas County")
        )
        mMap.addMarker(
            MarkerOptions().position(memorialHospitalOfTexasCounty).title("Memorial Hospital Of Texas County")
        )
        mMap.addMarker(
            MarkerOptions().position(medicalCenterOfOdessa).title("Medical Center of Odessa")
        )
        mMap.addMarker(
            MarkerOptions().position(universityOfUtahHospital).title("University Of Utah Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(texasHealthPresbyterianHospitalDenton).title("Texas Health Presbyterian Hospital Denton")
        )
        mMap.addMarker(
            MarkerOptions().position(texasHealthHarrisMethodistHospital).title("Texas Health Harris Methodist Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(texasHealthMedicalHearthMethodistHospital).title("Texas Health Medical Hearth Methodist Hospital")
        )
//        mMap.addMarker(
//            MarkerOptions().position(hcaHoustonHealthcareMainland).title("HCA Houston Healthcare Mainland")
//        )
        mMap.addMarker(
            MarkerOptions().position(baylorScottAndWhiteMedicalCenter).title("Baylor Scott and White Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(reevesCountyHospitalDistrict).title("Reeves County Hospital District")
        )
        mMap.addMarker(
            MarkerOptions().position(texasMedicalCenter).title("Texas Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(iraanGeneralHospital).title("Iraan General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(texasOrthopedicHospital).title("Texas Orthopedic Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(johnHopkinsHospital).title("John Hopkins University")
        )
        mMap.addMarker(
            MarkerOptions().position(texasHealthMedicalHearthMethodistHospital).title("Texas Health Medical Hearth Methodist Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(theWomensHospitalOfTexas).title("The women's hospital of Texas")
        )
        mMap.addMarker(
            MarkerOptions().position(penRoseHospital).title("Penrose Hospitals")
        )
        mMap.addMarker(
            MarkerOptions().position(stFrancisMedicalCenter).title("Encompass Health Rehabilitation Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(encompassHealthRehabilitationHospital).title("Encompass Health Rehabilitation Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(ucHealthGrandViewHospital).title("UC Health Grand View Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(mcKayDeeHospital).title("McKay Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(davisHospitalAndMedicalCenter).title("Davis Hosputal And Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(parkCityHospital).title("Park City Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(timpanogosRegionalHospital).title("Timpanogos Regional Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(ldsHospital).title("Cache Valley Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(cacheValleyHospital).title("Cache Valley Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(notreDameHospitalCcsmtlHeadOffice).title("Notre Dame Hospital CCSMTL Head Office")
        )
        mMap.addMarker(
            MarkerOptions().position(shrinersHospitalsForChildrenSaltLakeCity).title("Shriners Hospitals For Children Salt Lake City")
        )
        mMap.addMarker(
            MarkerOptions().position(utahStateHospital).title("Utah State Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(mesaViewRegionalHospital).title("Mesa View Regional Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(springValleyHospitalMedicalCenter)
                .title("Mike O'Callaghan Military Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(boulderCityHospital).title("Boulder City Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(mikeOcallaghanMilitaryMedicalCenter)
                .title("Mike O'Callaghan Military Medical Center")
        )

        mMap.addMarker(
            MarkerOptions().position(renownRegionalMedicalCenter)
                .title("Renown Regional Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(hendersonHospital).title("Henderson Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(carsonTahoeRegionalMedicalCenter)
                .title("Carson Tahoe Regional Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(northEasternNevadaRegionalHosptital)
                .title("North Eastern Nevada Regional Hosptital")
        )
        mMap.addMarker(
            MarkerOptions().position(sunriseHospitalMedicalCenter)
                .title("Sunrise Hospital Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(pershingGeneralHospital).title("Pershing General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(mountGrantGeneralHospital)
                .title("Mount Grant General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(northVistaHospital).title("North Vista Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(southernHillsHospitalAndMedicalCenter)
                .title("Southern Hills Hospital and Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(diginityHealthStRoseDominicanHospital).title("Dignity Health")
        )
        mMap.addMarker(
            MarkerOptions().position(stJoesphsMedicalCenter).title("St. Joesph's Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(huntingtonHospital).title("Huntington Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(dignityHealth).title("Dignity Health")
        )
        mMap.addMarker(
            MarkerOptions().position(mayersMemorialHospital).title("Mayers Memoriral Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(whitmanHospitalAndMedicalClinics)
                .title("Whitman Hospital and Medical Clinics")
        )
        mMap.addMarker(
            MarkerOptions().position(triStateMemorialHospitalAndMedicalCampus)
                .title("Tristate Memorial Hospital and Medical Campus")
        )
        mMap.addMarker(
            MarkerOptions().position(daytonGeneralHospital).title("Dayton General Hosptial")
        )
        mMap.addMarker(
            MarkerOptions().position(masonGeneralHospital).title("Mason General Health")
        )
        mMap.addMarker(
            MarkerOptions().position(skylineHealth).title("Skyline Health")
        )
        mMap.addMarker(
            MarkerOptions().position(highlineMedicalCenter).title("Highline Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(navalHospital).title("Naval Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(multiCareTacomaGeneralHospital)
                .title("MultiCare Tacoma General Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(snoqualmieValleyHospital).title("Snoqualmie Valley Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(westernStateHospital).title("Western State Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(easternStateHospital).title("Eastern State Hosital")
        )
        mMap.addMarker(
            MarkerOptions().position(multiCareGoodSamaritanHospital)
                .title("MultiCare Good Samaritan")
        )
        mMap.addMarker(
            MarkerOptions().position(uwMedicalCenterNorthwestSeattleHospital)
                .title("UW Medical Center Northwest Seattle Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartChildrenHospitalSpokane)
                .title("Sacred Heart Hospital Spokane")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceStPeterHospitalOlympia)
                .title("Providence St. Peter Hosptial Olympia")
        )
        mMap.addMarker(
            MarkerOptions().position(graysHarborCommunityHospital).title("Gray's Harbor Community")
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartChildrensHosptial)
                .title("Sacred Heart Children's Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(harrisonMedicalCenter).title("Harrison Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMountCarmelHospital)
                .title("Providence Mount Carmel Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(columbiaBasinHosptial).title("Columbia Basin Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceStMaryMedicalCenterWallaWalla)
                .title("Providence St.Mary Medical Center Walla Walla")
        )
        mMap.addMarker(
            MarkerOptions().position(centralWashingtonHosptial).title("Central Washington Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(pioneerMemorialHospital).title("Pioneer Memorial Hosiptal")
        )
        mMap.addMarker(
            MarkerOptions().position(sageViewPsychiatrists).title("Sage View Psychiatrists")
        )

        mMap.addMarker(
            MarkerOptions().position(redmondClinic).title("Redmond Clinic")
        )
        mMap.addMarker(
            MarkerOptions().position(bayAreaHospital).title("Bay Area Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(eastMorelandHospital).title("East Moreland Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(legacyMountHoodMedicalCenter).title("Legacy Mount Hood")
        )
        mMap.addMarker(
            MarkerOptions().position(adventistHealthPortland).title("Adventist Health Portland")
        )
        mMap.addMarker(
            MarkerOptions().position(stAnthonyHospital).title("St. Anthony Hospital ")
        )
        mMap.addMarker(
            MarkerOptions().position(cottageGroveCommunityMedicalCenter)
                .title("Cottage Grove Community Medical Center")
        )

        mMap.addMarker(
            MarkerOptions().position(veteransAffairsMedicalCenterOregon)
                .title("Veterans Affairs Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(westValleyHospital).title("West Valley Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(adventistHealthTillamook).title("Adventist Health Center")
        )
        mMap.addMarker(
            MarkerOptions().position(midColumbiaMedicalCenterEmergencyRoom)
                .title("Mid Columbia Medical Center Emergency Room")
        )
        mMap.addMarker(
            MarkerOptions().position(mcKenzieWillametteMedicalCenter)
                .title("McKenzie Willamette Medical Center")
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
            MarkerOptions().position(legacyEmanuelMedicalCenter)
                .title("Legacy Emanuel Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(southernCoosHospitalandHealthCenter)
                .title("Southern Coos Hospital and Health Center")
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
            MarkerOptions().position(providenceSwindellsResourceCenter)
                .title("Providence Swindells Resource Center")
        )
        mMap.addMarker(
            MarkerOptions().position(grandeRondeHospital).title("Grande Ronde Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartMedicalCenterUniversityDistrict)
                .title("Sacred Heart Medical Center University District")
        )
        mMap.addMarker(
            MarkerOptions().position(peaceHealthPeaceHarborMedicalCenter)
                .title("Peace Health Peace Harbor Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(samariatanLebanonCommunityHospital)
                .title("Samariatan Lebanon Community Hospital")
        )

        mMap.addMarker(
            MarkerOptions().position(lakeDistrictMedicalCenter).title("Lake District Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(skyLakesMedicalCenter)
                .title("Sky Lakes medical center Klamath Falls")
        )
        mMap.addMarker(
            MarkerOptions().position(ProvidenceMedicalCenterMedford)
                .title("Providence Medical Center Medford ")
        )
        mMap.addMarker(
            MarkerOptions().position(goodSamaritanRegionalMedicalCenter)
                .title("St. Charles Medical Center")
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
            MarkerOptions().position(vaPortlandHealthCareSystem)
                .title("Veteran Affairs Portland Health Care System")
        )
//
        mMap.addMarker(
            MarkerOptions().position(oregonHealthAndScienceUniversity)
                .title("Oregon Health and Science University")
        )
        mMap.addMarker(
            MarkerOptions().position(goodShepardHealthCareSystem)
                .title("Good Shepard Health Care System")
        )
        mMap.addMarker(
            MarkerOptions().position(blueMountainHospital).title("Blue Mountain Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(asanteThreeRiversMedicalCenter)
                .title("Asante Three Rivers Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(samaritanAlbanyGeneralHospital)
                .title("Samaritan Albany General Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(stJoesphMedicalClinic).title("St. Joesph Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceCentrailiaHospital)
                .title("Providence Centrailia Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(kaiserPermanenteWestsideMedicalCenter)
                .title("Kaiser Permanente Westside Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(tualityCommunityHospital).title("Tuality Community Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(samaritanNorthLincolnHospital)
                .title("Samartian North Lincoln Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(legacySilverton).title("Legacy Silverton Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(oregonStateHospital).title("Oregon State Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(peakMedicalNorthwestIncorporated)
                .title("Peak Medical Northwest Incorporated")
        )
        mMap.addMarker(
            MarkerOptions().position(shrinersHospitalsForChildrenQuebec)
                .title("Shriners Hospital for Children, Quebec")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceHoodRiver).title("Providence Hood River Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMilwaukieHospital)
                .title("Providence Milwaukie Hospital")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMedicalGroupBeaverton)
                .title("Providence Medical Group Beaverton")
        )
        mMap.addMarker(
            MarkerOptions().position(clackamasPediatricClinic).title("Clackamas Pediatric Clinic")
        )
        mMap.addMarker(
            MarkerOptions().position(oregonClinicSouth).title("Oregon Clinic South")
        )

        mMap.addMarker(
            MarkerOptions().position(providenceNewbergMedicalCenter)
                .title("Providence Newberg Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMedicalPlazaSherwood)
                .title("Providence Medical Plaza Sherwood")
        )
        mMap.addMarker(
            MarkerOptions().position(legacyMeridianParkMedicalCenter)
                .title("Legacy Meridian Park Medical Plaza")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceCanbyMedicalPlaza).title("Providence Medical Plaza")
        )
        mMap.addMarker(
            MarkerOptions().position(providenceWilametteFallsMedicalCenter)
                .title("Providence Wilamette Falls Medical Center")
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
            MarkerOptions().position(universityOfWashingtonMedicalCenter)
                .title("University of Washington Medical Center")
        )
        mMap.addMarker(
            MarkerOptions().position(brighamCityCommunityHospital)
                .title("Brigham City Community Hospital")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(providenceBridgeport))


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