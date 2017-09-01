package com.donghun2017.AlarmGom;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alfo06-23 on 2017-09-01.
 */

public class MyCursorAdapter extends SimpleCursorAdapter {
    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //super.bindView(view, context, cursor);

        TextView tvTime = (TextView) view.findViewById(R.id.week);
        TextView tvCurrentTime = (TextView) view.findViewById(R.id.time);

        tvTime.setText(cursor.getString(cursor.getColumnIndex("min")));
        tvCurrentTime.setText(cursor.getString(cursor.getColumnIndex("time")));


    }

}
