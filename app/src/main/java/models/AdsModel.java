package models;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by haier_1 on 4/29/2017.
 */

public class AdsModel {
    private String name  = "";
    private LatLng location ; //if any

    public AdsModel(String name, LatLng location) {
        this.name = name;
        this.location = location;
    }

    public AdsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
