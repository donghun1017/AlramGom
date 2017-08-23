package com.donghun2017.alramgom;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class RepeatAddActivity extends AppCompatActivity {

    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_add);


    }

    public void clickRepeatCheck(View v) {
        finish();
    }

//    public void clickTime(View v){
//        timePickerDialog = new TimePickerDialog(this, android.R.style.Theme_Material_Dialog ,new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                Toast.makeText(RepeatAddActivity.this, hourOfDay+"씨"+minute+"뿐", Toast.LENGTH_SHORT).show();
//            }
//        }, 15, 24, false);
//
//        timePickerDialog.show();
//    }

    public void clickTime(View v){

        TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
        finish();

        ///타임피커랑 타임피커알럿다이얼로그에서 갈등하고있음 숫자나오는 법을 찾기바람
    }

    public void clickWeek(View v){

    }

    public void clickRingtone(View v){
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALL);
        startActivityForResult(intent, 120);
    }






}
