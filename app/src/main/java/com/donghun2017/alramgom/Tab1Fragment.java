package com.donghun2017.alramgom;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.app.Activity.RESULT_OK;


public class Tab1Fragment extends Fragment {

    ArrayList<WakeUpAlarmItem> items = new ArrayList<>();

    WakeUpAlarmAdapter wakeUpAlarmAdapter;
    RecyclerView wakeUpRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    Button btnOneOff, btnRe;

    int hour, min;

    AlarmManager alarmManager;

    String formatDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        wakeUpRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_alarm);
        wakeUpAlarmAdapter = new WakeUpAlarmAdapter(items, getActivity());
        wakeUpRecyclerView.setAdapter(wakeUpAlarmAdapter);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        wakeUpRecyclerView.setLayoutManager(layoutManager);

        btnOneOff = (Button)view.findViewById(R.id.wakeUp_oneOff);
        btnRe = (Button)view.findViewById(R.id.wakeUp_Repeat);

        btnOneOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OneOffAddActivity.class);
                startActivityForResult(intent, 10);
            }
        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RepeatAddActivity.class);
                startActivityForResult(intent, 20);
            }
        });

//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(!isChecked){
//                    Intent intent = new Intent(getActivity(), AlarmActivity.class);
//                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                    alarmManager.cancel(pendingIntent);
//                }
//            }
//        });

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
        formatDate = sdfNow.format(date);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    min= data.getIntExtra("Min", 0);
                    Toast.makeText(getActivity(), formatDate, Toast.LENGTH_SHORT).show();
                    items.add(new WakeUpAlarmItem(true, formatDate, min+"분 뒤", "아이유", false, false, 1, R.mipmap.ic_launcher));
                    wakeUpAlarmAdapter.notifyDataSetChanged();

                    Intent intent = new Intent(getActivity(), AlarmActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);



                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+min*1000, pendingIntent);
                    }else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+min*1000, pendingIntent);
                    }else{
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+min*1000, min*1000, pendingIntent);
                    }
                }
                break;

            case 20:
                if(resultCode==RESULT_OK){
                    hour= data.getIntExtra("Hour", 0);
                    min= data.getIntExtra("Min", 0);
                    items.add(new WakeUpAlarmItem(true, hour+":"+min, "월 화 수 목", "아이유", false, false, 1, R.mipmap.ic_launcher));
                    wakeUpAlarmAdapter.notifyDataSetChanged();
                }

                break;


        }
    }//result


}
