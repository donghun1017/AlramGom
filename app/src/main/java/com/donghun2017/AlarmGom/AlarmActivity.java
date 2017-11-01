package com.donghun2017.AlarmGom;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AlarmActivity extends AppCompatActivity{

    AlarmManager alarmManager;
    Vibrator vibrator;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(new long[]{1000, 1000, 1000}, 0);

        textView = (TextView)findViewById(R.id.clock_currently);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("a HH:mm");
        textView.setText(sdfNow.format(date).toString());

        //
    }

    public void clickAlarmCheck(View v){
        vibrator.cancel();
        finish();
    }

    public void clickAlarm5Min(View v){
        vibrator.cancel();
        Intent intent = new Intent(this, AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+300*1000, pendingIntent);
        }else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+300*1000, pendingIntent);
        }else{
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+300*1000, 300*1000, pendingIntent);
        }

        finish();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vibrator.cancel();
        finish();
    }
}
