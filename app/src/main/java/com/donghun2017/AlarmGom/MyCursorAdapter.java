package com.donghun2017.AlarmGom;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alfo06-23 on 2017-09-01.
 */

public class MyCursorAdapter extends SimpleCursorAdapter {

    SQLiteDatabase db;
    SimpleCursorAdapter cursorAdapter;
    String tableName="member";

    Cursor cursor1;
    int id;

    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public void bindView(View view, Context context, final Cursor cursor) {
        //super.bindView(view, context, cursor);
        final Context c= context;

        TextView tvTime = (TextView) view.findViewById(R.id.week);
        TextView tvCurrentTime = (TextView) view.findViewById(R.id.time);

        tvTime.setText(cursor.getString(cursor.getColumnIndex("min")));
        tvCurrentTime.setText(cursor.getString(cursor.getColumnIndex("time")));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(c, "asaaaa", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(c, "롱클릭", Toast.LENGTH_SHORT).show();


                //cursor1 = (Cursor)cursorAdapter.getItem(1);
                id = cursor.getInt(cursor1.getColumnIndex("_id"));

                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setMessage("이 알람을 삭제하시겠습니까?");
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int num = db.delete(tableName, "_id=?", new String[]{id+""});
                        Toast.makeText(c, num+"가 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                        cursor1 = db.rawQuery("SELECT * FROM " + tableName, null);
                        cursorAdapter.changeCursor(cursor1);
                    }
                });
                builder.create().show();

                return true;
            }
        });



    }

}
