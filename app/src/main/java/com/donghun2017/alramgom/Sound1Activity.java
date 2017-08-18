package com.donghun2017.alramgom;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;

public class Sound1Activity extends AppCompatActivity {

    MediaPlayer mp3;
    ToggleButton toggleSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound1);

        mp3 = MediaPlayer.create(this, R.raw.rain_sound1);
        mp3.setLooping(true);

        toggleSound = (ToggleButton)findViewById(R.id.toggle_music);
        toggleSound.setOnCheckedChangeListener(changeListener);

    }

    @Override
    protected void onResume() {
        if(mp3!=null && !mp3.isPlaying()){
            mp3.setVolume(0.5f, 0.5f);
            mp3.start();
        }
        super.onResume();
    }

    public void clickToggle(View v){
        if(mp3 != null && mp3.isPlaying()) mp3.pause();
        else mp3.start();
    }

    @Override
    protected void onDestroy() {
        if(mp3 != null){
            mp3.stop();
            mp3.release();
            mp3=null;
        }

        super.onDestroy();
    }

    CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.toggle_music:
                    if(toggleSound.isChecked())toggleSound.setChecked(true);
                    else toggleSound.setChecked(false);

                    break;
            }
        }
    };
}
