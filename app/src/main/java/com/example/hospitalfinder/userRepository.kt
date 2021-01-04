import org.json.JSONArray

class UserViewModel(
    val repo:IUserRepository
)

class IUserRepository {

}
public class PlaceJSONParser {
    //Define empty hashmap
    val hashMap:HashMap<Int,String> = HashMap<Int,String>() //define empty hashmap
    //hashMap.put(1,"Ajay")

    //Receives a JSONObject and returns a list
    //public List<HashMap<String, String>> parse(JSONObject jObject){
        //JSONArray jPlace = null
    //}
}
//package com.example.hospitalfinder
//
//import android.os.Parcel
//import android.os.Parcelable
//import android.telecom.Call
//import com.google.android.gms.common.api.Response
//import java.util.concurrent.atomic.AtomicLong;

//
//class UserRepository() : Parcelable {
//    private val webservice: Webservice = TODO()
//
//    constructor(parcel: Parcel) : this() {
//    }
//
//    // ...
//    fun getUser(userId: String): LiveData<User> {
//        // This isn't an optimal implementation. We'll fix it later.
//        val data = MutableLiveData<User>()
//        webservice.getUser(userId).enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                data.value = response.body()
//            }
//            // Error case is left out for brevity.
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                TODO()
//            }
//        })
//        return data
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
//    companion object CREATOR : Parcelable.Creator<UserRepository> {
//        override fun createFromParcel(parcel: Parcel): UserRepository {
//            return UserRepository(parcel)
//        }
//
//        override fun newArray(size: Int): Array<UserRepository?> {
//            return arrayOfNulls(size)
//        }
//    }
//}