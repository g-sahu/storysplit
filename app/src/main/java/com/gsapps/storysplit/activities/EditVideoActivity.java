package com.gsapps.storysplit.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import static com.gsapps.storysplit.R.id;
import static com.gsapps.storysplit.R.layout.activity_edit_video;

public class EditVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_edit_video);

        Uri uri = getIntent().getData();
        VideoView videoView = findViewById(id.videoView);
        videoView.setVideoURI(uri);
        Bitmap thumbnail = getVideoThumbnail(uri);

        if(thumbnail == null) {
            videoView.seekTo( 1);
        } else {
            videoView.setBackground(new BitmapDrawable(getResources(), thumbnail));
        }
    }

    private Bitmap getVideoThumbnail(Uri uri) {
        MediaMetadataRetriever mMMR = new MediaMetadataRetriever();
        mMMR.setDataSource(this, uri);
        return mMMR.getFrameAtTime();
    }
}



