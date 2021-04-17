package com.example.safar;

import android.location.Address;

public class Location {

    /**
     * Location Name
     */

    private String mLocation;

    /**
     * Image for the location
     */

    private int mLocationImageResourceId;

    /**
     * Information about the location
     */

    private int mLocationInfo;

    /**
     *  Location to be searched on the map to locate the location
     */

    private String mLocationResourceId;

    /**
     *  Address for the location
     */

    private int mAddress;

    /**
     * Timing for the location
     */

    private int mTiming;

    /**
     * Call Information of the location
     */

    private int mCall;


    public Location(String Location, int LocationImageResourceId, int LocationInfo, String LocationResourceId, int Address, int Timing, int Call) {
        mLocation = Location;
        mLocationImageResourceId = LocationImageResourceId;
        mLocationInfo = LocationInfo;
        mLocationResourceId = LocationResourceId;
        mAddress = Address;
        mTiming = Timing;
        mCall = Call;
    }

    /**
     * getter methods for the above defined variables
     */

    public String getLocation() {
        return mLocation;
    }

    public int getLocationImageResourceId() {
        return mLocationImageResourceId;
    }

    public int getLocationInfo() {
        return mLocationInfo;
    }

    public String getLocationResourceId() {
        return mLocationResourceId;
    }

    public int getAddress() {
        return mAddress;
    }

    public int getTiming() {
        return mTiming;
    }

    public int getCall() {
        return mCall;
    }

}
