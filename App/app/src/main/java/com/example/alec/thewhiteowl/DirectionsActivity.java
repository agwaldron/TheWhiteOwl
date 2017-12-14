package com.example.alec.thewhiteowl;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class DirectionsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int ERROR_DIALOG_REQUEST = 9001;
    String owlAddress = null;
    double lattitude = 0;
    double longitude = 0;
    Button directionsToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_directions);

        owlAddress = getString(R.string.address_string);

        directionsToHome = (Button)findViewById(R.id.directions_to_home);
        directionsToHome.setTextColor(getResources().getColor(R.color.colorDark, null));
        directionsToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectHome();
            }
        });

        if(servicesOK()){
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_container);
            mapFragment.getMapAsync(this);

            Geocoder gc = new Geocoder(this);
            List<Address> list;
            try {
                list = gc.getFromLocationName(owlAddress, 1);
                Address address = list.get(0);
                lattitude = address.getLatitude();
                longitude = address.getLongitude();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Error locating address", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplication(), "Couldn't Connect to Google API", Toast.LENGTH_LONG).show();
        }
    }

    public void redirectHome(){
        finish();
        this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

    public boolean servicesOK() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);

        if (result == ConnectionResult.SUCCESS) {
            return true;
        } else if (googleAPI.isUserResolvableError(result)) {
            googleAPI.getErrorDialog(this, result,ERROR_DIALOG_REQUEST).show();
        } else {
            Toast.makeText(this, "Can't connect to mapping service", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng owlLatLng = new LatLng(lattitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(owlLatLng).title("The White Owl"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(owlLatLng, 15));
    }
}
