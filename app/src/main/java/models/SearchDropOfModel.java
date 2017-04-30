package models;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by haier_1 on 4/29/2017.
 */

public class SearchDropOfModel {
    private String dropoff ;
    private LatLng location ;


    public SearchDropOfModel(String dropoff, LatLng location) {
        this.dropoff = dropoff;
        this.location = location;
    }

    public String getDropoff() {
        return dropoff;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
