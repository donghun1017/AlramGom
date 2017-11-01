package com.donghun2017.AlarmGom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by alfo06-23 on 2017-08-09.
 */

public class ListViewAdapter2 extends BaseAdapter {

    CircleImageView circleImageView;
    TextView textView;

    ArrayList<ListViewItem2> members;
    LayoutInflater inflater;

    public ListViewAdapter2(ArrayList<ListViewItem2> members, LayoutInflater inflater) {
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
            convertView = inflater.inflate(R.layout.listview_item2, null);
        }

        ListViewItem2 member = members.get(position);

        String title = member.getTitle();
        int titleImg = member.getTitleImg();

        textView = (TextView)convertView.findViewById(R.id.sound_text);
        circleImageView = (CircleImageView) convertView.findViewById(R.id.sound_img);

        textView.setText(title);
        Glide.with(convertView).load(titleImg).into(circleImageView);

        return convertView;
    }
}
