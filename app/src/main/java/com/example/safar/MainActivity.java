package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Finding the View that shows the historical places category */

        TextView historicalPlaces = findViewById(R.id.historical_places_button);

        /** Setting a click listener on for the historical places TextView */

        historicalPlaces.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoricalPlacesActivity.class);
            startActivity(intent);
        });

        /** Finding the View that shows the food category */

        TextView food = findViewById(R.id.food_button);

        /** Setting a click listener on for the food TextView */

        food.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            startActivity(intent);
        });

        /** Finding the View that shows the national parks category */

        TextView nationalparks = findViewById(R.id.national_parks_button);

        /** Setting a click listener on for the national parks TextView */

        nationalparks.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NationalParkActivity.class);
            startActivity(intent);
        });

        /** Finding the View that shows the beaches category */

        TextView beaches = findViewById(R.id.beaches_button);

        /** Setting a click listener on for the beaches TextView */

        beaches.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BeachesActivity.class);
            startActivity(intent);
        });

    }
}