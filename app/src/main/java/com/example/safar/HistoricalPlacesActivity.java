package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalPlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("Taj Mahal", R.drawable.taj_mahal, R.string.taj_mahal, "Taj Mahal,Agra", R.string.taj_mahal_address, R.string.taj_mahal_timing, R.string.taj_mahal_call));
        locations.add(new Location("Red Fort", R.drawable.red_fort, R.string.red_fort, "Red Fort", R.string.red_fort_address, R.string.red_fort_timing, R.string.red_fort_call));
        locations.add(new Location("Ellora Caves", R.drawable.ellora_caves, R.string.ellora_caves, "Ellora Caves", R.string.ellora_caves_address, R.string.ellora_caves_timing, R.string.ellora_caves_call));
        locations.add(new Location("Golden Temple", R.drawable.golden_temple, R.string.golden_temple, "Golden Temple", R.string.golden_temple_address, R.string.golden_temple_timing, R.string.golden_temple_call));

        //Setting the custom LocationAdapter over the ListView

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_historic_places);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(adapter);

        // Using maps Intent to locate the location on google maps

        listview.setOnItemClickListener((parent, view, position, l) -> {
            Location location = locations.get(position);
            String address = location.getLocation();
            String geoUri = "http://maps.google.com/maps?q=loc:" + address;
            Uri mapUri = Uri.parse("geo:" + geoUri);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

    }
}