package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BeachesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        getSupportActionBar().setHomeButtonEnabled(true);

        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("Candolim", R.drawable.candolim_beach, R.string.candolim_beach, "Candolim Beach", R.string.candolim_address, R.string.candolim_timing, R.string.candolim_call));
        locations.add(new Location("Puri", R.drawable.puri_beach, R.string.puri_beach, "Puri Beach", R.string.puri_address, R.string.puri_timing, R.string.puri_call));
        locations.add(new Location("Radhanagar", R.drawable.radhanagar_beach, R.string.radhanagar_beach, "Radhanagar Beach", R.string.radhanagar_address, R.string.radhanagar_timing, R.string.radhanagar_call));
        locations.add(new Location("Varkala", R.drawable.varkala_beach, R.string.varkala_beach, "Varkala Beach", R.string.varkala_address, R.string.varkala_timing, R.string.varkala_call));

        //Setting the custom LocationAdapter over the ListView

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_beaches);
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
