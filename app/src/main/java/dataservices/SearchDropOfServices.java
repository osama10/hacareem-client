package dataservices;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import models.SearchDropOfModel;

/**
 * Created by haier_1 on 4/29/2017.
 */

public class SearchDropOfServices {
    private static  SearchDropOfModel data [] = {new SearchDropOfModel("Nagan" ,new LatLng(233, 23)) ,new SearchDropOfModel("PECHS" ,new LatLng(233, 23)), new SearchDropOfModel("Kashmir Road" ,new LatLng(233, 23))};

   public static SearchDropOfModel[]  getDropoffs(String dropoff){
//        SearchDropOfModel dropOf = null ;
//            for(int i = 0 ; i < data.length ; i++){
//                if(dropoff .equals(data[i].getDropoff())){
//                    dropOf = data[i];
//                }
//        }
        return  data;
    }
}
