package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.myrestaurants.Constants;
import com.epicodus.myrestaurants.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindRestaurantsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.findRestaurantsButton:
                String location = mLocationEditText.getText().toString();
                saveLocationToFirebase(location);

//                if(!(location).equals("")) {
//                    addToSharedPreferences(location);
//                }
                Toast.makeText(MainActivity.this, "Hi there!", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
//                intent.putExtra("location", location); THIS LINE NO LONGER NEEDED BECAUSE THIS IS SAVED TO SHARED PREFERENCES
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    private void saveLocationToFirebase(String location) {
        Firebase searchedLocationRef = new Firebase(Constants.FIREBASE_URL_SEARCHED_LOCATION);
        searchedLocationRef.push().setValue(location);
    }

//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }

}
