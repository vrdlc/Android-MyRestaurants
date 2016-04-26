package com.epicodus.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Guest on 4/25/16.
 */

@Parcel
public class Restaurant {
    public String mName;
    public String mPhone;
    public String mWebsite;
    public double mRating;
    public String mImageUrl;
    public ArrayList<String> mAddress = new ArrayList<>();
    public double mLatitude;
    public double mLongitude;
    public ArrayList<String> mCategories = new ArrayList<>();

    public Restaurant() {

    }

    public Restaurant(String name, String phone, String website,
                      double rating, String imageUrl, ArrayList<String> address,
                      double latitude, double longitude, ArrayList<String> categories) {
        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mAddress = address;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mCategories = categories;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return  mWebsite;
    }

    public double getRating() {
        return mRating;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public ArrayList<String> getAddress() {
        return mAddress;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public ArrayList<String> getCategories() {
        return mCategories;
    }
}
