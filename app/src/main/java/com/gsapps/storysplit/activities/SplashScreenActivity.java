package com.gsapps.storysplit.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gsapps.storysplit.R;

import static android.util.Log.d;

public class SplashScreenActivity extends Activity {
    private final String LOG_TAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        d(LOG_TAG, "SplashScreenActivity created");
        Intent intent = new Intent(this, HomeActivity.class);
        d(LOG_TAG, "Starting " + intent.getComponent().getShortClassName());
        startActivity(intent);
        d(LOG_TAG, "Exiting " + getLocalClassName());
    }
}
