package com.example.hospitalfinder
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
class PlaceJSONParser(args:Array<String>) {
    //JSONArray jPlaces = null;
    val jsonObject = JSONObject(strJson)

    private fun JSONObject(strJson: strJson): Any {
    return JSONObject()
    }

    val JSONArray = "Employee"
    //@Serializable
    //val jsonObject2 = JSONObject(data)
    //jsonObject.optJSONArray("Employee")
    // Receives a JSONObject and returns a list
   /* public HashMap parse(JSONObject jObject)
    {


       try
       {
               /**Retrieves all the elements in the 'places; array */
                jPlaces =v  jObject.getJSONArray("result");
       }


    }*/
    var hashMap: HashMap<String, Int> = HashMap<String, Int>()
    //printing the Empty hashMap

}
public class PlaceDetailsJSONParser{
    /* Receives a JSONObject and returns a list*/
    /*public HashMap<String,String> parse(JSONObject jObject)
   {

       JSONObject jPlaceDetails = null;
       try{
           //Retrieves all the elements in the 'places' array
           jPlaceDetails = jObject.getJSONObject("result");
       }
       catch(JSONException e)
       {
           e.printStackTrace();
       }
       Invoking getPlaces with the array of json object where each json object represent a place
       return new HashMap<String, String>;
   }*/
}

object strJson {

}

