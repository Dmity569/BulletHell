package com.example.spacegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreatorsActivity extends AppCompatActivity {
    SharedPreferences mSettings;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSettings = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
        float volume = (float) mSettings.getInt("music", 50);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_creators);
        mp = MediaPlayer.create(this, R.raw.creators_main_frame);
        mp.setLooping(true);
        mp.seekTo(0);

        int MAX_VOLUME = 100;

        final float volume_x = (float) (1 - (Math.log(MAX_VOLUME - volume) / Math.log(MAX_VOLUME)));
        mp.setVolume(volume_x, volume_x);

        mp.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();

    }
}

