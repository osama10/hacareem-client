package inventslab.hacareemps_2.com.hacareem.views;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hacreem.shared_resources.Constants;

import inventslab.hacareemps_2.R;

public class RidenowActivity extends AppCompatActivity implements OnMapReadyCallback , GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    SupportMapFragment mMapFrag;
    GoogleMap mMap;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    double latitude;
    double longitude;
    private boolean doesLocationReceived = false;
    private String typeOfRide = "";

    Button btn_Ridenow;
    Button btn_Tab_Go;
    TextView tv_Tab_Go ;
    Button btn_Tab_Gop;
    TextView tv_Tab_Gop ;
    Button btn_Tab_Buisness;
    TextView tv_Tab_Buisness ;
    Button btn_Tab_Tezz;
    TextView tv_Tab_Tezz ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ridenow);
        initView();
        mMapFrag    = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFrag.getMapAsync(this);

        if (checkPlayServices()) {

            buildGoogleApiClient();
        }
        onClickHandler();


        tv_Tab_Go.setBackgroundColor(Color.WHITE);
        tv_Tab_Gop.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
        tv_Tab_Buisness.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
        tv_Tab_Tezz.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));

    }

        private void onClickHandler(){
            btn_Ridenow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(RidenowActivity.this , ConfirmDropoffActivity.class);
                    startActivity(i);
                }
            });

            btn_Tab_Go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    typeOfRide = Constants.GO ;
                    tv_Tab_Go.setBackgroundColor(Color.WHITE);
                    tv_Tab_Gop.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Buisness.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Tezz.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));

                }
            });
            btn_Tab_Gop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    typeOfRide = Constants.GOP ;
                    tv_Tab_Go.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Gop.setBackgroundColor(Color.WHITE);
                    tv_Tab_Buisness.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Tezz.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                }
            });

            btn_Tab_Buisness.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    typeOfRide = Constants.BUISNESS ;
                    tv_Tab_Go.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Gop.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Buisness.setBackgroundColor(Color.WHITE);
                    tv_Tab_Tezz.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                }
            });

            btn_Tab_Tezz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    typeOfRide = Constants.TEZZ;
                    tv_Tab_Go.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Gop.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Buisness.setBackgroundColor(getResources().getColor(R.color.tabsBackGroundColor));
                    tv_Tab_Tezz.setBackgroundColor(Color.WHITE);

                }
            });


        }
    private void displayLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);


            if (mLastLocation != null) {
                latitude = mLastLocation.getLatitude();
                longitude = mLastLocation.getLongitude();

                doesLocationReceived = true ;
                LatLng loc = new LatLng(latitude, longitude);

                mMap.addMarker(new MarkerOptions().position(loc).title("My Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc , 13.5f));

            } else {
                doesLocationReceived = false;
            }
        }
        else{
            Toast.makeText(getApplicationContext() , "Permission Denied" , Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        displayLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }
    void initView(){
        btn_Ridenow = (Button) findViewById(R.id.btn_ridenow);
        btn_Tab_Go =  (Button) findViewById(R.id.id_btn_tab_go);
        tv_Tab_Go = (TextView) findViewById(R.id.id_tv_tab_go);
        btn_Tab_Gop =  (Button) findViewById(R.id.id_btn_tab_gop);
        tv_Tab_Gop = (TextView) findViewById(R.id.id_tv_tab_gop);
        btn_Tab_Buisness =  (Button) findViewById(R.id.id_btn_tab_buisness);
        tv_Tab_Buisness= (TextView) findViewById(R.id.id_tv_tab_buisness);
        btn_Tab_Tezz =  (Button) findViewById(R.id.id_btn_tab_tezz);
        tv_Tab_Tezz = (TextView) findViewById(R.id.id_tv_tab_tezz);
    }
}
