package com.daclink.drew.sp22.cst438_project01_starter;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.MissingResourceException;


public class MusixMatch extends Activity {
    private musiXmatchLyricsConnector mLyricsPlugin = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_musix_match);

        final String artistName = "";
        final String trackName = "";

        mLyricsPlugin = new musiXmatchLyricsConnector(this);
        mLyricsPlugin.setLoadingMessage("Your custom title", "Your custom message");

        findViewById(R.id.showLyrics).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mLyricsPlugin.startLyricsActivity(artistName, trackName);
                } catch (MissingResourceException e) {
                    mLyricsPlugin.downloadLyricsPlugin();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        mLyricsPlugin.doBindService();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mLyricsPlugin.doUnbindService();
        super.onPause();
    }
}