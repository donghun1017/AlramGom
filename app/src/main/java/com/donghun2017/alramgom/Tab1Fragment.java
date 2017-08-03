package com.donghun2017.alramgom;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Tab1Fragment extends Fragment {

    ArrayList<WakeUpAlarmItem> items = new ArrayList<>();

    WakeUpAlarmAdapter wakeUpAlarmAdapter;
    RecyclerView wakeUpRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items.add(new WakeUpAlarmItem(true, "05:31 오전", "월 화 수", "아이유", false, false, 1, R.mipmap.ic_launcher));

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

        return view;

    }







}
