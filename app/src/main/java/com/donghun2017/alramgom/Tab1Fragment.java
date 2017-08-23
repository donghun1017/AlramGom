package com.donghun2017.alramgom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class Tab1Fragment extends Fragment {

    ArrayList<WakeUpAlarmItem> items = new ArrayList<>();

    WakeUpAlarmAdapter wakeUpAlarmAdapter;
    RecyclerView wakeUpRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    Button btnOneOff, btnRe;

    int min;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items.add(new WakeUpAlarmItem(true, "10:00 오전", "9분 뒤", "아이유", false, false, 1, R.mipmap.ic_launcher));
        items.add(new WakeUpAlarmItem(true, "05:31 오전", "월 화 수", "아이유", false, false, 1, R.mipmap.ic_launcher));
        items.add(new WakeUpAlarmItem(true, "11:50 오후", "월 화 수", "아이유", false, false, 1, R.mipmap.ic_launcher));

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

//        btnOneOff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), OneOffAddActivity.class);
//                startActivityForResult(intent, 10);
//            }
//        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RepeatAddActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        switch (requestCode){
//            case 10:
//                if(resultCode==RESULT_OK){
//                    min= data.getIntExtra("Min", 0);
//                    Toast.makeText(getActivity(), min+"", Toast.LENGTH_SHORT).show();
//                    items.add(new WakeUpAlarmItem(true, "10:00 오전", min+"", "아이유", false, false, 1, R.mipmap.ic_launcher));
//                }
//                break;
//        }
//    }
}
