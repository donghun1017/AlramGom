package com.donghun2017.alramgom;

import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;

public class Sound1Activity extends AppCompatActivity {

    MediaPlayer mp3;
    ToggleButton toggleSound;
    ImageView clock;
    TextView clockTime;

    Dialog dialog;

    AlertDialog.Builder builder;
    View view;

    float leftVolume = 0.3f;
    float rightVolume = 0.3f;

    SeekBar sb;
    AudioManager audioManager;
    int max;
    int currentVolume;

    WatchThread watchThread;
    int min = 00;
    int sec = 00;

    boolean isrunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound1);

        mp3 = MediaPlayer.create(this, R.raw.rain_sound1);
        mp3.setLooping(true);

        toggleSound = (ToggleButton) findViewById(R.id.toggle_music);
        toggleSound.setOnCheckedChangeListener(changeListener);

        sb = (SeekBar) findViewById(R.id.seekbar1);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        sb.setMax(max);
        sb.setProgress(currentVolume);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onResume() {
        if (mp3 != null && !mp3.isPlaying()) {
            mp3.setVolume(leftVolume, rightVolume);
            mp3.start();
        }
        super.onResume();
    }

    public void clickToggle(View v) {
        if (mp3 != null && mp3.isPlaying()) mp3.pause();
        else mp3.start();
    }

    public void clickToggle2(View v) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("타이머 시간 설정");
        view = getLayoutInflater().inflate(R.layout.timer, null);
        builder.setView(view);
        dialog = builder.create();
        dialog.show();

        clock = (ImageView) findViewById(R.id.toggle_timer);
        clockTime = (TextView) findViewById(R.id.timer_text);
    }

    @Override
    protected void onDestroy() {
        if (mp3 != null) {
            mp3.stop();
            mp3.release();
            mp3 = null;
        }

        super.onDestroy();
    }

    CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.toggle_music:
                    if (toggleSound.isChecked()) toggleSound.setChecked(true);
                    else toggleSound.setChecked(false);

                    break;
            }
        }
    };

    public void clickTimer1(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.VISIBLE);
        clockTime.setVisibility(View.GONE);

    }

    public void clickTimer2(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        sec = 10;
        watchThread.start();

}

    public void clickTimer3(View v) {
        dialog.dismiss();
    }


class WatchThread extends Thread {

    @Override
    public void run() {

        while (sec > -1) {

            sec--;

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    String watch = String.format("%02d:%02d", min, sec);
                    clockTime.setText(watch);

                    if (sec < 0) {
                        clockTime.setVisibility(View.GONE);
                        clock.setVisibility(View.VISIBLE);

                        if (mp3 != null) {
                            mp3.pause();
                            toggleSound.setChecked(true);

                        }
                    }
                }

            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }//runMethod

}//WatchThread


}
