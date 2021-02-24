package com.manuh.havacodinginterview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.manuh.havacodinginterview.adapter.TripAdapter;
import com.manuh.havacodinginterview.model.Trip;
import com.manuh.havacodinginterview.viewmodel.TripViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TripResultsActivity extends AppCompatActivity {

    TripViewModel viewModel;
    private List<Trip> finalTrips;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_results);

        recyclerView = findViewById(R.id.trips_recyclerview);

        String searchKeyword = getIntent().getStringExtra("search_keyword");
        String distanceRange = getIntent().getStringExtra("distance");
        String timeRange = getIntent().getStringExtra("time");
        boolean switchStatus = getIntent().getBooleanExtra("switch", false);

        viewModel = new ViewModelProvider(this).get(TripViewModel.class);
        viewModel.getTrips(this);

        viewModel.getTripList().observe(this, trips -> {

            List<Trip> rederTrips = filterListWithConditions(searchKeyword, distanceRange, timeRange, switchStatus, trips);
            buildRecyclerView((ArrayList<Trip>) rederTrips);
            getSupportActionBar().setTitle("Trips (" + rederTrips.size() + ")");
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        List<Trip> testTrips = new ArrayList<>();

        Trip a = new Trip(89, "CANCELED", "2019-07-04 13:41:39", -1.28119150,
                36.81729370, "11 Koinange St, Nairobi", -1.26184760, 36.80412170,
                "9 West, Mkungu Cl, Nairobi", "2019-07-04 13:42:05",
                null, "Basic", 9, "Richard", 0, "https://hr.hava.bz/trips/p9.jpg",
                "Nissan", "March", "KCQ-6711", 2015, "https://hr.hava.bz/trips/c9.jpg",
                0, "min", 0.0, "km", 0, "KES");

        Trip b = new Trip(78, "COMPLETED", "2019-07-04 11:21:49", -1.30624440,
                36.82700470, "Peugot, Nairobi", -1.28387390, 36.81903250, "City Market Building, Koinange Street, Nairobi",
                "2019-07-04 11:31:14", "2019-07-04 11:45:14", "Basic", 9, "Richard", 5, "https://hr.hava.bz/trips/p9.jpg",
                "Nissan", "March", "KCQ-6711", 2015, "https://hr.hava.bz/trips/c9.jpg", 14, "min",
                3.13, "km", 225, "KES");

        testTrips.add(a);
        testTrips.add(b);

    }

    public List<Trip> filterListWithConditions(String searchKeyword, String distanceRange, String timeRange, Boolean switchStatus, List<Trip> trips) {
        if (!switchStatus) {

            ListIterator<Trip> iter = trips.listIterator();
            while (iter.hasNext()) {
                if (iter.next().getStatus().equals("CANCELED")) {
                    iter.remove();
                }
            }
        }

        List<Trip> kilometreFilter = new ArrayList<>();
        switch (distanceRange) {
            case "Any":
                kilometreFilter = trips;
                break;
            case "Under 3 Km": {
                Predicate<Trip> validPredicate = item -> item.getDistance() < 3;
                Collection<Trip> result = filter(trips, validPredicate);
                kilometreFilter = (List<Trip>) result;
                break;
            }
            case "3 to 8 Km": {
                Predicate<Trip> validPredicate = item -> item.getDistance() >= 3 && item.getDistance() <= 8;
                Collection<Trip> result = filter(trips, validPredicate);
                kilometreFilter = (List<Trip>) result;
                break;
            }
            case "8 to 15 Km": {
                Predicate<Trip> validPredicate = item -> item.getDistance() >= 8 && item.getDistance() <= 15;
                Collection<Trip> result = filter(trips, validPredicate);
                kilometreFilter = (List<Trip>) result;
                break;
            }
            case "More than 15 Km": {
                Predicate<Trip> validPredicate = item -> item.getDistance() > 15;
                Collection<Trip> result = filter(trips, validPredicate);
                kilometreFilter = (List<Trip>) result;
                break;
            }
        }

        List<Trip> timeFilter = new ArrayList<>();

        switch (timeRange) {
            case "Any":
                timeFilter = kilometreFilter;
                break;
            case "Under 5 min": {
                Predicate<Trip> validPredicate = item -> item.getDuration() < 5;
                Collection<Trip> result = filter(kilometreFilter, validPredicate);
                timeFilter = (List<Trip>) result;
                break;
            }
            case "5 to 10 min": {
                Predicate<Trip> validPredicate = item -> item.getDuration() >= 5 && item.getDuration() <= 10;
                Collection<Trip> result = filter(kilometreFilter, validPredicate);
                timeFilter = (List<Trip>) result;
                break;
            }
            case "10 to 20 min": {
                Predicate<Trip> validPredicate = item -> item.getDuration() >= 10 && item.getDuration() <= 20;
                Collection<Trip> result = filter(kilometreFilter, validPredicate);
                timeFilter = (List<Trip>) result;
                break;
            }
            case "More than 20 min": {
                Predicate<Trip> validPredicate = item -> item.getDuration() > 20;
                Collection<Trip> result = filter(kilometreFilter, validPredicate);
                timeFilter = (List<Trip>) result;
                break;
            }
        }

        finalTrips = timeFilter;

        return filter(searchKeyword);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public static <T> Collection<T> filter(Collection<T> col, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<>();
        for (T element : col) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public interface Predicate<T> {
        boolean apply(T type);
    }

    private List<Trip> filter(String text) {
        ArrayList<Trip> filteredList = new ArrayList<>();
        for (Trip item : finalTrips) {
            if (item.getPickupLocation().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getPickupLocation().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getDropoffLocation().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getType().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getDriverName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getCarMake().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getCarModel().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            } else if (item.getCarNumber().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    private void buildRecyclerView(ArrayList<Trip> trips) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        TripAdapter adapter = new TripAdapter(trips);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}

