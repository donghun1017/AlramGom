package com.donghun2017.AlarmGom;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class RepeatAddActivity extends AppCompatActivity {

    TimePickerDialog timePickerDialog;

    ToggleButton mon, tues, wednes, thurs, fri, satur, sun;
    boolean[] booleen = new boolean[7];

    String strRingTone = "";
    TextView textRing;
    TextView textTime;
    Calendar datetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_add);

        mon = (ToggleButton) findViewById(R.id.toggle_monday);
        tues = (ToggleButton) findViewById(R.id.toggle_tuesday);
        wednes = (ToggleButton) findViewById(R.id.toggle_wednesday);
        thurs = (ToggleButton) findViewById(R.id.toggle_thursday);
        fri = (ToggleButton) findViewById(R.id.toggle_friday);
        satur = (ToggleButton) findViewById(R.id.toggle_saturday);
        sun = (ToggleButton) findViewById(R.id.toggle_sunday);

        mon.setOnCheckedChangeListener(listener);
        tues.setOnCheckedChangeListener(listener);
        wednes.setOnCheckedChangeListener(listener);
        thurs.setOnCheckedChangeListener(listener);
        fri.setOnCheckedChangeListener(listener);
        satur.setOnCheckedChangeListener(listener);
        sun.setOnCheckedChangeListener(listener);

        textRing = (TextView)findViewById(R.id.text_ring);
        textTime = (TextView)findViewById(R.id.text_time);

    }

    public void clickRepeatCheck(View v) {
//        Intent intent = getIntent();
//        intent.putExtra("Hour", datetime.get(Calendar.HOUR_OF_DAY));
//        intent.putExtra("Min", datetime.get(Calendar.MINUTE));
//        setResult(RESULT_OK, intent);
        Toast.makeText(this, "죄송합니다. 개발중입니다^_^", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void clickTime(View v) {
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String am_pm = "";

                datetime = Calendar.getInstance();
                datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                datetime.set(Calendar.MINUTE, minute);

                if (datetime.get(Calendar.AM_PM) == Calendar.AM)
                    am_pm = "오전";
                else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
                    am_pm = "오후";


                String strHrsToShow = (datetime.get(Calendar.HOUR) == 0) ?"12":datetime.get(Calendar.HOUR)+"";
                if(datetime.get(Calendar.MINUTE) != 0){
                    textTime.setText(am_pm+" "+strHrsToShow+"시 "+datetime.get(Calendar.MINUTE)+"분");
                }else{
                    textTime.setText(am_pm+" "+strHrsToShow+"시 "+"00분");
                }


            }
        }, 0, 0, false);

        timePickerDialog.show();

    }

    public void clickRingtone(View v) {
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALL);
        startActivityForResult(intent, 120);
    }

    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if (mon.isChecked()) {
                mon.setTextColor(0XFF00897B);
                booleen[0]=true;
            }else{
                mon.setTextColor(0XFF757575);
                booleen[0]=false;
            }

            if (tues.isChecked()) {
                tues.setTextColor(0XFF00897B);
                booleen[1]=true;
            }else{
                tues.setTextColor(0XFF757575);
                booleen[1]=false;
            }

            if (wednes.isChecked()) {
                wednes.setTextColor(0XFF00897B);
                booleen[2]=true;
            }else{
                wednes.setTextColor(0XFF757575);
                booleen[2]=false;
            }

            if (thurs.isChecked()) {
                thurs.setTextColor(0XFF00897B);
                booleen[3]=true;
            }else{
                thurs.setTextColor(0XFF757575);
                booleen[3]=false;
            }

            if (fri.isChecked()) {
                fri.setTextColor(0XFF00897B);
                booleen[4]=true;
            }else{
                fri.setTextColor(0XFF757575);
                booleen[4]=false;
            }

            if (satur.isChecked()) {
                satur.setTextColor(0XFF00897B);
                booleen[5]=true;
            }else{
                satur.setTextColor(0XFF757575);
                booleen[5]=false;
            }

            if (sun.isChecked()) {
                sun.setTextColor(0XFF00897B);
                booleen[6]=true;
            }else{
                sun.setTextColor(0XFF757575);
                booleen[6]=false;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==120 && resultCode==RESULT_OK) {
            Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
            if(uri != null){
                strRingTone = uri.toString();
                Ringtone ringtone = RingtoneManager.getRingtone(this, uri);
                textRing.setText(ringtone.getTitle(this));

            }
        }
    }




}
