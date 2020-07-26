//Abdullah Mutaz Alshawa
// 7/8/20
// Hospital Locator
// Locates the directions to hospitals for COVID 19 treatment. The application is linked to Google Maps to give you a Google Maps API when you click on a hospital lankmark.
// Synopsis: Shows hospitals in California, Idaho, Oregon and Washington. When you click on location on you can use the Google Maps API to navigate to the landmark. The Google Maps application supports people traveling on foot, by vehicle or bus

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
import kotlinx.android.synthetic.main.activity_main.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mapFragment.onResume()
        mapFragment.allowEnterTransitionOverlap
        mapFragment.activity
        mapFragment.textView.setText("Hello and Welcome!")

        if(mapFragment.isRemoving)
            println("Application is closing!")

        }

    override fun onMapReady(googleMap: GoogleMap) {

        authenticateFirebase()
        mMap = googleMap

        //Initialize the declared variables
        val providenceBridgeport = LatLng(45.39, -122.75)
        val dignityHealth = LatLng(44.26,-121.28)
        val stCharlesPrineville = LatLng(44.30,-121.11)
        val providenceMercantile = LatLng(45.42, -122.72)
        val providenceStVincent = LatLng(45.46,-122.792)
        val oregonHealthAndScienceUniversity = LatLng(45.48,-122.81)
        val universityOfWashingtonMedicalCenter = LatLng(46.53,-123.75)
        val providenceWilametteFallsMedicalCenter = LatLng(45.42,-122.72)
        val legacyGoodSamaritan = LatLng(45.42,-122.85)
        val pioneerMemorialHospital = LatLng(44.83,-120.76)
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
        val legacyMountHoodMedicalCenter = LatLng(45.42,-122.72)
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
        val huntingtonHospital = LatLng(44.26,-121.28)
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
        val adventistHealthTillamook = LatLng(45.42,-122.72)
        val westValleyHospital = LatLng(45.42,-122.72)
        val veteransAffairsMedicalCenterOregon = LatLng(45.42,-122.72)
        val cottageGroveCommunityMedicalCenter = LatLng(45.42, -122.72)
        val stAnthonyHospital = LatLng(45.42,-122.72)
        val adventistHealthPortland = LatLng(45.42,-122.72)
        val eastMorelandHospital = LatLng(45.47,-122.64)
        val bayAreaHospital = LatLng(45.42, -122.72)
        val redmondClinic = LatLng(44.26,-121.28)
        val sageViewPsychiatrists = LatLng(44.07,-121.41)
        val centralWashingtonHosptial = LatLng(47.21,-125.11)
        val providenceStMaryMedicalCenterWallaWalla = LatLng(46.75,-123.56)
        val columbiaBasinHosptial = LatLng(47.04,-125.12)
        val providenceMountCarmelHospital = LatLng(46.86,-125.12)
        val harrisonMedicalCenter = LatLng(46.46,-125.39)
        val sacredHeartChildrensHosptial = LatLng(47.63,-120.39)
        val graysHarborCommunityHospital = LatLng(45.95,-127.36)
        val providenceStPeterHospitalOlympia = LatLng(47.05,-127.33)
        val sacredHeartChildrenHospitalSpokane = LatLng(46.43,-123.02)
        val uwMedicalCenterNorthwestSeattleHospital = LatLng(47.02,-123.66)
        val multiCareGoodSamaritanHospital = LatLng (47.02,-122.88)
        val easternStateHospital = LatLng(45.66,-127.99)
        val westValleyMedicalCenter = LatLng(44.26,-121.30)
        val westernStateHospital = LatLng(47.18,-127.05)
        val snoqualmieValleyHospital = LatLng(47.00,-123.62)
        val multiCareTacomaGeneralHospital = LatLng(47.40,-123.13)
        val navalHospital = LatLng(46.98,-123.99)
        val highlineMedicalCenter = LatLng(46.98,-123.99)
        val skylineHealth = LatLng(45.86,-123.90)
        val masonGeneralHospital = LatLng(46.95,-125.05)
        val daytonGeneralHospital = LatLng(46.92,-123.10)
        val whitmanHospitalAndMedicalClinics = LatLng(46.87,-119.62)
        val triStateMemorialHospitalAndMedicalCampus = LatLng(46.60,-117.75)
        val mayersMemorialHospital = LatLng(43.43,-130.59)
        val stJoesphsMedicalCenter = LatLng(44.26,-121.28)
        val diginityHealth = LatLng(44.26,-121.28)
        val easternIdahoRegionalMedicalCenter = LatLng(43.33,-121.15)
        val mountainViewHospital = LatLng(44.26,-121.26)
        val stLukesNampaMedicalCenter = LatLng(44.654,-121.20)
        val minidokaMemorial = LatLng(44.26,-121.26)
        val madisonMemorialHospital = LatLng(44.26, -121.26)
        val northernNevadaMedicalCenter = LatLng(41.87,-123.03)
        val childrensHospitalofNevada = LatLng(44.00,-121.40)

        mMap.addMarker(
            MarkerOptions().position(childrensHospitalofNevada).title(childrensHospitalofNevada.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(northernNevadaMedicalCenter).title(northernNevadaMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(mcKenzieWillametteMedicalCenter).title(mcKenzieWillametteMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(coquilleValleyHospital).title(coquilleValleyHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(westValleyHospital).title(westValleyHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(adventistHealthTillamook).title(adventistHealthTillamook.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(midColumbiaMedicalCenterEmergencyRoom).title(midColumbiaMedicalCenterEmergencyRoom.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(madisonMemorialHospital).title(madisonMemorialHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(minidokaMemorial).title(minidokaMemorial.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(stLukesNampaMedicalCenter).title(stLukesNampaMedicalCenter.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(westValleyMedicalCenter).title(westValleyMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(mountainViewHospital).title(mountainViewHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(easternIdahoRegionalMedicalCenter).title(easternIdahoRegionalMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(stCharlesPrineville).title(stCharlesMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(diginityHealth).title(diginityHealth.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(stJoesphsMedicalCenter).title(stJoesphMedicalClinic.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(huntingtonHospital).title(huntingtonHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(dignityHealth).title(diginityHealth.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(mayersMemorialHospital).title(mayersMemorialHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(whitmanHospitalAndMedicalClinics).title(whitmanHospitalAndMedicalClinics.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(triStateMemorialHospitalAndMedicalCampus).title(triStateMemorialHospitalAndMedicalCampus.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(daytonGeneralHospital).title(daytonGeneralHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(masonGeneralHospital).title(masonGeneralHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(skylineHealth).title(skylineHealth.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(highlineMedicalCenter).title(highlineMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(navalHospital).title(navalHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(multiCareTacomaGeneralHospital).title(multiCareTacomaGeneralHospital.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(snoqualmieValleyHospital).title(snoqualmieValleyHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(westernStateHospital).title(westValleyHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(easternStateHospital).title(easternStateHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(multiCareGoodSamaritanHospital).title(multiCareGoodSamaritanHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(uwMedicalCenterNorthwestSeattleHospital).title(uwMedicalCenterNorthwestSeattleHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartChildrenHospitalSpokane).title(sacredHeartChildrenHospitalSpokane.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceStPeterHospitalOlympia).title(providenceStPeterHospitalOlympia.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(graysHarborCommunityHospital).title(graysHarborCommunityHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartChildrensHosptial).title(sacredHeartChildrensHosptial.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(harrisonMedicalCenter).title(harrisonMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMountCarmelHospital).title(providenceMountCarmelHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(columbiaBasinHosptial).title(columbiaBasinHosptial.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceStMaryMedicalCenterWallaWalla).title(providenceStMaryMedicalCenterWallaWalla.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(centralWashingtonHosptial).title(centralWashingtonHosptial.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(pioneerMemorialHospital).title(pioneerMemorialHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(sageViewPsychiatrists).title(sageViewPsychiatrists.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(redmondClinic).title(redmondClinic.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(bayAreaHospital).title(bayAreaHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(eastMorelandHospital).title(eastMorelandHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(legacyMountHoodMedicalCenter).title(legacyMountHoodMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(adventistHealthPortland).title(adventistHealthPortland.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(stAnthonyHospital).title(stAnthonyHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(cottageGroveCommunityMedicalCenter).title(cottageGroveCommunityMedicalCenter.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(veteransAffairsMedicalCenterOregon).title(veteransAffairsMedicalCenterOregon.toString())
        )
        mMap.addMarker(

            MarkerOptions().position(curryGeneralHospital).title(curryGeneralHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(woodlandParkHospital).title(woodlandParkHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(legacyEmanuelMedicalCenter).title(legacyEmanuelMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(southernCoosHospitalandHealthCenter).title(southernCoosHospitalandHealthCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(columbiaMemorialHospital).title(columbiaBasinHosptial.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(harneyDistrictHospital).title(harneyDistrictHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(stAlphonsusMedicalCenter).title(stAlphonsusMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(salemHealthHospital).title(salemHealthHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceSwindellsResourceCenter).title(providenceSwindellsResourceCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(grandeRondeHospital).title(grandeRondeHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(sacredHeartMedicalCenterUniversityDistrict).title(sacredHeartMedicalCenterUniversityDistrict.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(peaceHealthPeaceHarborMedicalCenter).title(peaceHealthPeaceHarborMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(samariatanLebanonCommunityHospital).title(samariatanLebanonCommunityHospital.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(lakeDistrictMedicalCenter).title(lakeDistrictMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(skyLakesMedicalCenter).title(skyLakesMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(ProvidenceMedicalCenterMedford).title(ProvidenceMedicalCenterMedford.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(goodSamaritanRegionalMedicalCenter).title(goodSamaritanRegionalMedicalCenter.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(stCharlesMedicalCenter).title(stCharlesMedicalCenter.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(legacySalmonCreek).title(legacySalmonCreek.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(oregonClinicCardiology).title(oregonClinicCardiology.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(vaPortlandHealthCareSystem).title(vaPortlandHealthCareSystem.toString())
        )
//
        mMap.addMarker(
            MarkerOptions().position(oregonHealthAndScienceUniversity).title(oregonHealthAndScienceUniversity.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(goodShepardHealthCareSystem).title(goodShepardHealthCareSystem.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(blueMountainHospital).title(blueMountainHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(asanteThreeRiversMedicalCenter).title(asanteThreeRiversMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(samaritanAlbanyGeneralHospital).title(samaritanAlbanyGeneralHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(stJoesphMedicalClinic).title(stJoesphMedicalClinic.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceCentrailiaHospital).title(providenceCentrailiaHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(kaiserPermanenteWestsideMedicalCenter).title(kaiserPermanenteWestsideMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(tualityCommunityHospital).title(tualityCommunityHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(samaritanNorthLincolnHospital).title(samaritanNorthLincolnHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(legacySilverton).title(legacySilverton.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(oregonStateHospital).title(oregonStateHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(peakMedicalNorthwestIncorporated).title(peakMedicalNorthwestIncorporated.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(shrinersHospitalsForChildren).title(shrinersHospitalsForChildren.toString())
        )
        mMap.addMarker(
                    MarkerOptions().position(providenceHoodRiver).title(providenceHoodRiver.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMilwaukieHospital).title(providenceMilwaukieHospital.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMedicalGroupBeaverton).title(providenceMedicalGroupBeaverton.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(clackamasPediatricClinic).title(clackamasPediatricClinic.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(oregonClinicSouth).title(oregonClinicSouth.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(providenceNewbergMedicalCenter).title(providenceNewbergMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMedicalPlazaSherwood).title(providenceMedicalPlazaSherwood.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(legacyMeridianParkMedicalCenter).title(legacyMeridianParkMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceCanbyMedicalPlaza).title(providenceCanbyMedicalPlaza.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceWilametteFallsMedicalCenter).title(providenceWilametteFallsMedicalCenter.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(legacyGoodSamaritan).title(legacyGoodSamaritan.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceBridgeport).title(providenceBridgeport.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(providenceMercantile).title(providenceMercantile.toString())
        )

        mMap.addMarker(
            MarkerOptions().position(providenceStVincent).title(providenceStVincent.toString())
        )
        mMap.addMarker(
            MarkerOptions().position(universityOfWashingtonMedicalCenter).title(universityOfWashingtonMedicalCenter.toString())
        )
        //mMap.addCircle()
        mMap.moveCamera(CameraUpdateFactory.newLatLng(providenceBridgeport))


        val hospitalUrl = "http://maps.google.co.uk/maps?q=Hospital&hl=en"


        Intent(Intent.ACTION_VIEW, Uri.parse(hospitalUrl));

        




    }}


fun authenticateFirebase() {
}

