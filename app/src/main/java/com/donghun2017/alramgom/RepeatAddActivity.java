package com.donghun2017.alramgom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class RepeatAddActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;

    ArrayList<ListViewItem> members = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_add);

       members.add(new ListViewItem("6:50 오전", "월 화 수", null, "김범수 - 첫사랑", true, true, R.mipmap.ic_launcher_round, "성공?"));

        listView = (ListView)findViewById(R.id.listView);
        LayoutInflater inflater = getLayoutInflater();
        adapter = new ListViewAdapter(members, inflater);
        listView.setAdapter(adapter);

    }
}
