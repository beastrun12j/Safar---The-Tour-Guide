package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("Delhi", R.drawable.delhi, R.string.delhi, "Delhi", R.string.delhi_address, R.string.delhi_timing, R.string.delhi_call));
        locations.add(new Location("Mumbai", R.drawable.mumbai, R.string.mumbai, "Mumbai", R.string.mumbai_address, R.string.mumbai_timing, R.string.mumbai_call));
        locations.add(new Location("Hyderabad", R.drawable.hyderabad, R.string.hyderabad, "Hyderabad", R.string.hyderabad_address, R.string.mumbai_timing, R.string.mumbai_call));
        locations.add(new Location("Udupi", R.drawable.udupi, R.string.udupi, "Udupi", R.string.udupi_address, R.string.udupi_timing, R.string.udupi_call));

        //Setting the custom LocationAdapter over the ListView

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_food);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(adapter);

        // Using maps Intent to locate the location on google maps

        listview.setOnItemClickListener((parent, view, position, l) -> {
            Location location = locations.get(position);
            String address = location.getLocationResourceId();
            String geoUri = "http://maps.google.com/maps?q=loc:" + address;
            Uri mapUri = Uri.parse("geo:" + geoUri);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

    }
}