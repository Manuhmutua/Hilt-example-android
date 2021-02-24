package com.manuh.havacodinginterview;

import com.manuh.havacodinginterview.model.Trip;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FilterFunctionTest {

    private TripResultsActivity tripResultsActivity = new TripResultsActivity();
    private List<Trip> testTrips = new ArrayList<>();

    @Before
    public void setUp() {

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

    @Test
    public void test_keyword_filter() {
        int size = tripResultsActivity.filterListWithConditions("Peugot, Nairobi", "Any", "Any", false, testTrips).size();
        assertEquals(1, size);
    }

    @Test
    public void test_distance_filter() {
        int size = tripResultsActivity.filterListWithConditions("", "3 to 8 Km", "Any", false, testTrips).size();
        assertEquals(1, size);
    }

    @Test
    public void test_time_filter() {
        int size = tripResultsActivity.filterListWithConditions("", "Any", "10 to 20 min", false, testTrips).size();
        assertEquals(1, size);
    }

    @Test
    public void test_switch_filter() {
        int size = tripResultsActivity.filterListWithConditions("", "Any", "Any", true, testTrips).size();
        assertEquals(2, size);
    }

}
