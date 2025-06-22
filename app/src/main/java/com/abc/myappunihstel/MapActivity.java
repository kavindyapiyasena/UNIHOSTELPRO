package com.abc.myappunihstel;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText addressInput;
    private Button showLocationBtn;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        addressInput = findViewById(R.id.addressInput);
        showLocationBtn = findViewById(R.id.showLocationBtn);
        recyclerView = findViewById(R.id.locationRecycler);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        showLocationBtn.setOnClickListener(v -> {
            String address = addressInput.getText().toString();
            if (!address.isEmpty()) {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocationName(address, 1);
                    if (addresses != null && !addresses.isEmpty()) {
                        Address location = addresses.get(0);
                        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.clear();
                        mMap.addMarker(new MarkerOptions().position(latLng).title("Location found"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
                    } else {
                        Toast.makeText(this, "Address not found", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    Toast.makeText(this, "Geocoder error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ✅ Updated Location List with LatLng
        List<LocationInfo> locations = new ArrayList<>();
        locations.add(new LocationInfo(
                "Open University Colombo Regional Center", "Open", "7 PM", "0112881000",
                "Nugegoda", 6.882328997559563, 79.88784227382286)); // Accurate CRC

        locations.add(new LocationInfo(
                "HSS Building, The Open University of Sri Lanka", "Open", "4:15 PM", "0112881000",
                "Nugegoda - Academic Department", 6.8835, 79.8881)); // Approx dummy

        LocationAdapter adapter = new LocationAdapter(locations, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng initialLocation = new LatLng(6.882933363660906, 79.88672294023908);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 15f));
        mMap.addMarker(new MarkerOptions().position(initialLocation).title("Initial Location"));
    }
}
