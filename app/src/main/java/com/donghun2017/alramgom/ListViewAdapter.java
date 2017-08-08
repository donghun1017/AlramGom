package com.donghun2017.alramgom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-23 on 2017-08-04.
 */

public class ListViewAdapter extends BaseAdapter {

    ArrayList<ListViewItem> members;
    LayoutInflater inflater;

    public ListViewAdapter(ArrayList<ListViewItem> members, LayoutInflater inflater) {
        this.members = members;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_item, null);
        }

        ListViewItem member = members.get(position);
        String time = member.getTime();
        String week = member.getWeek();
        String selectDay = member.getSelectDay();
        String ring = member.getRing();
        boolean vibration = member.isVibration();
        boolean silent = member.isSilent();
        int clearImg = member.getClearImg();
        String memo = member.getMemo();

        TextView textTime = (TextView)convertView.findViewById(R.id.text_time);
        TextView textWeek = (TextView)convertView.findViewById(R.id.text_week);
        TextView textRing = (TextView)convertView.findViewById(R.id.text_ring);
        ImageView clearId = (ImageView)convertView.findViewById(R.id.clear_img);

        textTime.setText(time);
        textWeek.setText(week);
        textRing.setText(ring);
        clearId.setImageResource(clearImg);


        return convertView;
    }
}
