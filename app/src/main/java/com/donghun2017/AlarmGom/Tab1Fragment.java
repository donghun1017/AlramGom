package com.donghun2017.AlarmGom;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;


public class Tab1Fragment extends Fragment {

    Button btnOneOff, btnRe;

    int time, hour, min;

    AlarmManager alarmManager;

    String formatDate;

    SimpleCursorAdapter cursorAdapter;
    DBOpenner openner;
    SQLiteDatabase db;
    String tableName="member";

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);

        openner = new DBOpenner(getActivity(), tableName, null, 1);
        db=openner.getWritableDatabase();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        listView = (ListView)view.findViewById(R.id.recycler_alarm);
        Cursor cursor = db.query(true, tableName, null, null, null, null, null, null, null);
        cursorAdapter = new MyCursorAdapter(getActivity(), R.layout.recycler_wakeup, cursor, new String[]{"min"}, new int[]{R.id.week}, 0);
        listView.setAdapter(cursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "클릭", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "롱클릭", Toast.LENGTH_SHORT).show();
                final int index = position;

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Delete?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Cursor cursor = (Cursor) cursorAdapter.getItem(index);
                        int id = cursor.getInt(cursor.getColumnIndex("_id") );

                        int num = db.delete(tableName, "_id=?", new String[]{id+""});
                        Toast.makeText(getActivity(), num+"가 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                        cursor = db.rawQuery("SELECT * FROM " +tableName, null);
                        cursorAdapter.changeCursor(cursor);
                    }
                });

                builder.setNegativeButton("CANCEL", null);
                builder.create().show();
                return true;
            }
        });



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


        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("a HH:mm");
        formatDate = sdfNow.format(date);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    min= data.getIntExtra("Min", 0);
                    ContentValues values = new ContentValues();
                    values.put("min", min+"분 후 알람");
                    values.put("time", formatDate);
                    long rowId=db.insert(tableName, null, values);
                    cursorAdapter.notifyDataSetChanged();
                    Toast.makeText(getActivity(), rowId+"번에 저장되었습니다.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getActivity(), AlarmActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+min*60*1000, pendingIntent);
                    }else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+min*60*1000, pendingIntent);
                    }else{
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+min*60*1000, min*60*1000, pendingIntent);
                    }
                }
                break;

            case 20:
                if(resultCode==RESULT_OK){
                    hour= data.getIntExtra("Hour", 0);
                    min= data.getIntExtra("Min", 0);
                    cursorAdapter.notifyDataSetChanged();
                }

                break;


        }
    }//result




}
