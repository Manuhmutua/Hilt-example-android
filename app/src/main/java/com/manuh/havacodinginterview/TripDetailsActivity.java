package com.manuh.havacodinginterview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.manuh.havacodinginterview.model.Trip;

public class TripDetailsActivity extends AppCompatActivity {

    MapView mMapView;
    private GoogleMap googleMap;
    private Trip t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        mMapView = findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Bundle data = getIntent().getExtras();
        assert data != null;
        t = data.getParcelable("trip");

        TextView requestDate = findViewById(R.id.request_date);
        TextView tripFinalPriceTop = findViewById(R.id.trip_final_price_top);
        TextView pickupLocation = findViewById(R.id.pickup_location);
        TextView dropoffLocation = findViewById(R.id.dropoff_location);
        TextView pickupTime = findViewById(R.id.pickup_time);
        TextView dropoffTime = findViewById(R.id.dropoff_time);
        ImageView carPic = findViewById(R.id.car_pic);
        TextView carMakeModel = findViewById(R.id.car_make_model);
        TextView distance = findViewById(R.id.trip_distance);
        TextView duration = findViewById(R.id.trip_duration);
        TextView tripTotal = findViewById(R.id.trip_total);
        TextView driverName = findViewById(R.id.driver_name);
        ImageView driverPic = findViewById(R.id.driver_pic);
        RatingBar ratingBar = findViewById(R.id.ratingBar);


        requestDate.setText(t.getRequestDate());
        tripFinalPriceTop.setText(t.getCost() + " " + t.getCostUnit());
        pickupLocation.setText(t.getPickupLocation());
        dropoffLocation.setText(t.getDropoffLocation());
        String[] splitedPickupDate = t.getPickupDate().split("\\s+");
        String[] splitedPickupTime = splitedPickupDate[1].split(":");
        pickupTime.setText(splitedPickupTime[0] + ":" + splitedPickupTime[1]);
        String[] splitedDropoffDate = t.getPickupDate().split("\\s+");
        String[] splitedDropoffTime = splitedDropoffDate[1].split(":");
        dropoffTime.setText(splitedDropoffTime[0] + ":" + splitedDropoffTime[1]);
        Glide.with(this).load(t.getCarPic()).into(carPic);
        carMakeModel.setText(t.getCarMake() + " " + t.getCarModel());
        distance.setText(t.getDistance() + " " + t.getDistanceUnit());
        duration.setText(t.getDuration() + " " + t.getDurationUnit());
        tripTotal.setText(t.getCost() + " " + t.getCostUnit());
        driverName.setText(t.getDriverName());
        Glide.with(this).load(t.getDriverPic()).into(driverPic);
        ratingBar.setRating(t.getDriverRating());
    }

    @Override
    protected void onStart() {
        super.onStart();

        mMapView.getMapAsync(mMap -> {
            googleMap = mMap;

            googleMap.setMyLocationEnabled(true);

            LatLng pickUp = new LatLng(t.getPickupLat(), t.getPickupLng());
            LatLng dropoff = new LatLng(t.getDropoffLat(), t.getDropoffLng());

            googleMap.addMarker(new MarkerOptions().position(pickUp).title("Pick up").snippet(t.getPickupLocation()));
            googleMap.addMarker(new MarkerOptions().position(dropoff).title("Drop off").snippet(t.getDropoffLocation()));

            CameraPosition cameraPosition = new CameraPosition.Builder().zoom(11).target(dropoff).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
