package com.gsapps.storysplit.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static com.gsapps.storysplit.R.layout.activity_home;
import static com.gsapps.storysplit.util.AppUtils.hasPermission;

public class HomeActivity extends Activity {
    private final String LOG_TAG = getClass().getSimpleName();

    //Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_home);
    }

    public void addNewFile(View view) {
        if(hasPermission(this, WRITE_EXTERNAL_STORAGE)) {

        } else {
            //Request read/write storage permission from the user
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch(requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                if(grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {

                }
            }
        }
    }
}
