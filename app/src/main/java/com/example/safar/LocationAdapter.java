package com.example.safar;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    private int mColorResourceId;

    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResourceId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Location currentLocation = getItem(position);

        // TextView for Location Name

        TextView Location = listItemView.findViewById(R.id.location_name);
        Location.setText(currentLocation.getLocation());

        //ImageView for image of the location

        ImageView LocationImage = listItemView.findViewById(R.id.location_image);
        LocationImage.setImageResource(currentLocation.getLocationImageResourceId());
        LocationImage.setVisibility(View.VISIBLE);

        //TextView for Information about the location

        TextView LocationInfo = listItemView.findViewById(R.id.location_info);
        LocationInfo.setText(currentLocation.getLocationInfo());

        //TextView for Address of the location

        TextView Address = listItemView.findViewById(R.id.address);
        Address.setText(currentLocation.getAddress());

        //TextView for Timings of the location

        TextView Timing = listItemView.findViewById(R.id.timing);
        Timing.setText(currentLocation.getTiming());

        //TextView for Contact Number of the location

        TextView Call = listItemView.findViewById(R.id.call);
        Call.setText(currentLocation.getCall());

        // Theme color for the list item

        View textContainer = listItemView.findViewById(R.id.card_View);

        // setting background colors by using the color that the resource ID maps to

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
