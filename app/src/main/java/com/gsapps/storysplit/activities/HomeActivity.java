package com.gsapps.storysplit.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.Intent.ACTION_OPEN_DOCUMENT;
import static android.content.Intent.CATEGORY_OPENABLE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.widget.Toast.*;
import static com.gsapps.storysplit.R.layout.activity_home;
import static com.gsapps.storysplit.util.AppUtils.hasPermission;

public class HomeActivity extends Activity {
    private final String LOG_TAG = getClass().getSimpleName();

    //Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {WRITE_EXTERNAL_STORAGE};
    private static final int READ_REQUEST_CODE = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_home);
    }

    public void addNewFile(View view) {
        if(hasPermission(this, WRITE_EXTERNAL_STORAGE)) {
            performFileSearch();
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
                    performFileSearch();
                }
            }
        }
    }

    public void performFileSearch() {
        Intent intent = new Intent(ACTION_OPEN_DOCUMENT);
        intent.addCategory(CATEGORY_OPENABLE);
        intent.setType("video/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK) {
            if (resultData != null) {
                Uri uri = resultData.getData();
                Log.i(LOG_TAG, "Uri: " + uri.toString());
                Intent intent = new Intent(this, EditVideoActivity.class);
                intent.setData(uri);
                startActivity(intent);
            }
        }
    }
}
