package com.example.proyecto;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.proyecto.databinding.ActivitySacursalesBinding;

public class sacursales extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivitySacursalesBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySacursalesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        bmc1234(googleMap);
    }

    public void bmc1234(GoogleMap googleMap){
        mMap = googleMap;

        final LatLng Punto1 = new LatLng(20.38915919813109, -99.9953166438902);
        mMap.addMarker(new MarkerOptions().position(Punto1).title("Zapatos centro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Punto1));
        final LatLng Punto2 = new LatLng(20.383426799844813, -99.9889437154034);
        mMap.addMarker(new MarkerOptions().position(Punto2).title("Zapatos Juarez"));
        final LatLng Punto3 = new LatLng(20.38590009650444, -99.96068717922529);
        mMap.addMarker(new MarkerOptions().position(Punto3).title("Zapatos Maquio"));
        final LatLng Punto4 = new LatLng(20.37706679703898, -99.96487753641487);
        mMap.addMarker(new MarkerOptions().position(Punto4).title("Zapatos Pedregoso"));

    }
}