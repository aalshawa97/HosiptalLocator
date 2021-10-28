package com.example.hospitalfinder

class Hospital (val name: String, val isOnline: Boolean) {

    companion object {
        private var lastHospitalId = 0
        fun createContactsList(numHospitals: Int) : ArrayList<Hospital> {
            val hospitals = ArrayList<Hospital>()
            for (i in 1..numHospitals) {
                hospitals.add(Hospital("Hospitals " + ++lastHospitalId, i <= numHospitals / 2))
            }
            return hospitals
        }
    }
}