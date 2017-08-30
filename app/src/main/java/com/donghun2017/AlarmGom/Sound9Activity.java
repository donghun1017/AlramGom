package com.donghun2017.AlarmGom;

import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class Sound9Activity extends AppCompatActivity {

    MediaPlayer mp3;
    MediaPlayer mp33;

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

    boolean isRunning = true;

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound9);

        adView = (AdView)findViewById(R.id.adview9);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mp3 = MediaPlayer.create(this, R.raw.rain_sound9);
        mp3.setLooping(true);
        mp33 = MediaPlayer.create(this, R.raw.piano_sound9);
        mp33.setLooping(true);

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

            mp33.setVolume(leftVolume, rightVolume);
            mp33.start();
        }
        super.onResume();
    }

    public void clickToggle(View v) {
        if (mp3 != null && mp3.isPlaying()) {
            mp3.pause();
            mp33.pause();
        }else{
            mp3.start();
            mp33.start();
        }
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
            mp33.stop();
            mp33.release();
            mp3 = null;
            mp33 = null;
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
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.VISIBLE);
        clockTime.setVisibility(View.GONE);

    }

    public void clickTimer2(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        sec = 60;
        watchThread.start();

    }

    public void clickTimer3(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 2;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer4(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 4;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer5(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 9;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer6(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 14;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer7(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 19;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer8(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 29;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer9(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 59;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer10(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 119;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer11(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 179;
        sec = 60;
        watchThread.start();
    }
    public void clickTimer12(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 299;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer13(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 359;
        sec = 60;
        watchThread.start();
    }

    public void clickTimer14(View v) {
        if (!mp3.isPlaying()) {
            mp3.start();
            mp33.start();
            toggleSound.setChecked(false);
        }
        dialog.dismiss();
        clock.setVisibility(View.GONE);
        clockTime.setVisibility(View.VISIBLE);

        watchThread = new WatchThread();
        min = 419;
        sec = 60;
        watchThread.start();
    }



    class WatchThread extends Thread {

        @Override
        public void run() {

            while (isRunning) {

                sec--;
                if(min!=0 && sec<0){
                    min--;
                    sec=59;
                }

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String watch = String.format("%02d:%02d", min, sec);
                        clockTime.setText(watch);

                        if (min == 0 && sec < 0) {
                            clockTime.setVisibility(View.GONE);
                            clock.setVisibility(View.VISIBLE);
                            isRunning = false;

                            if (mp3 != null) {
                                mp3.pause();
                                mp33.pause();
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

