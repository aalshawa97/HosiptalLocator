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
//        @Override
//        public boolean onQueryTextSubmit(String query)
//        {
//
//        }

        super.onCreate(savedInstanceState)
        //adapter
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

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        // Add a marker in Providence Bridgeport and move the camera
        val penRoseHospital = LatLng(45.4160656,-122.7229924)
        val providenceBridgeport = LatLng(45.39, -122.75)
        val dignityHealth = LatLng(44.26, -121.28)
        val providenceMercantile = LatLng(45.42, -122.72)
        val providenceStVincent = LatLng(45.46, -122.792)
        val oregonHealthAndScienceUniversity = LatLng(45.48, -122.81)
        val universityOfWashingtonMedicalCenter = LatLng(46.53, -123.75)
        val providenceWilametteFallsMedicalCenter = LatLng(45.42, -122.72)
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
        mMap.addMarker(
            MarkerOptions().position(theWomensHospitalOfTexas).title("The women's hospital of Texas!")
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
        mMap.moveCamera(CameraUpdateFactory.newLatLng(providenceBridgeport))


    }
    }
