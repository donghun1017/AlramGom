package com.donghun2017.AlarmGom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by alfo06-23 on 2017-08-01.
 */

public class WakeUpAlarmAdapter extends RecyclerView.Adapter<WakeUpAlarmAdapter.ViewHolder> {

    ArrayList<WakeUpAlarmItem> wakeUpAlarmItems;
    Context context;

    public WakeUpAlarmAdapter(ArrayList<WakeUpAlarmItem> wakeUpAlarmItems, Context context) {
        this.wakeUpAlarmItems = wakeUpAlarmItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_wakeup, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(wakeUpAlarmItems.get(position).imgId).into(holder.alarmImg);
        holder.time.setText(wakeUpAlarmItems.get(position).time);
        holder.week.setText(wakeUpAlarmItems.get(position).week);

    }


    @Override
    public int getItemCount() {
        return wakeUpAlarmItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        TextView week;
        ImageView alarmImg;


        public ViewHolder(View itemView) {
            super(itemView);

            time = (TextView)itemView.findViewById(R.id.time);
            week = (TextView)itemView.findViewById(R.id.week);
            alarmImg = (ImageView)itemView.findViewById(R.id.img);

        }


    }




}
