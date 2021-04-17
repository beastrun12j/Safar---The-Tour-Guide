package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NationalParkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("Gir", R.drawable.gir_national_forest, R.string.gir_national_park, "Gir National Park", R.string.gir_address, R.string.gir_timing, R.string.gir_call));
        locations.add(new Location("Kaziranga", R.drawable.kaziranga_national_park, R.string.kaziranga_national_park, "Kaziranga National Park", R.string.kaziranga_address, R.string.kaziranga_timing, R.string.kaziranga_call));
        locations.add(new Location("Sunderbans", R.drawable.sunderbans_national_park, R.string.sunderbans_national_park, "Sunderban National Park", R.string.sunderban_address, R.string.sunderban_timing, R.string.sunderban_call));
        locations.add(new Location("Ranthambore", R.drawable.ranthambore_national_park, R.string.ranthambore_national_park, "Ranthambore National Park", R.string.ranthambore_address, R.string.ranthambore_timing, R.string.ranthambore_call));

        //Setting the custom LocationAdapter over the ListView

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_national_parks);
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