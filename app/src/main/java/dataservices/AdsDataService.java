package dataservices;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import models.AdsModel;

/**
 * Created by haier_1 on 4/29/2017.
 */

public class AdsDataService {

   private static AdsModel [] data =  {new AdsModel("Get amazing discounts at Levis",new LatLng(23,43)) , new AdsModel("It's 20% off at GLoria Jeans",new LatLng(23,43))} ;
   public static AdsModel[] getAdsData(){
        return data;
    }
}
