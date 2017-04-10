package com.example.evilmonkey.truguideapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private static final LatLngBounds TRUBound = new LatLngBounds(new LatLng(13.715627, 100.345581), new LatLng(13.717476, 100.350287));
    private static final LatLng TRUCenter = new LatLng(13.716375, 100.348672);
    private static final LatLng TRU_VIEW = new LatLng(13.716291, 100.347623);

    private String[] Location_Name,Location_Icon,Location_Lat,Location_Lon,Location_Subtitle,Location_Detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        Location_Name = getResources().getStringArray(R.array.Location_Name);
        Location_Icon = getResources().getStringArray(R.array.Location_Icon);
        Location_Lat = getResources().getStringArray(R.array.Location_Lat);
        Location_Lon = getResources().getStringArray(R.array.Location_Lon);
        Location_Subtitle = getResources().getStringArray(R.array.Location_Subtitle);
        Location_Detail = getResources().getStringArray(R.array.Location_Detail);


        if(playServiceCheck()){
            Toast.makeText(this, "Welcome To Location View.", Toast.LENGTH_LONG).show();
            initMap();
        }

    }

    private void initMap(){
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.flg_1);
        mapFragment.getMapAsync(this);

    }

    public boolean playServiceCheck(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }
        else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable,0);
            dialog.show();
        }
        else{
            Toast.makeText(this, "Can't Connect to PlayService", Toast.LENGTH_LONG).show();
        }
        return false;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        int maxLocation = Location_Name.length;
        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(TRU_VIEW).zoom(18).bearing(65).tilt(50).build();
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        for(int i=0;i<=maxLocation-1;i++){
            Double lat = Double.parseDouble(Location_Lat[i]);
            Double lon = Double.parseDouble(Location_Lon[i]);
            LatLng location = new LatLng(lat,lon);
            //googleMap.addMarker(new MarkerOptions().position(location).title(Location_Name[i]).snippet(Location_Subtitle[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.mainlogo)));
            googleMap.addMarker(new MarkerOptions().position(location).title(Location_Name[i]).snippet(Location_Subtitle[i]));
        }

    }
}
