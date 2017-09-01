package com.donghun2017.AlarmGom;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alfo06-23 on 2017-09-01.
 */

public class DBOpenner extends SQLiteOpenHelper {

    String tableName;

    public DBOpenner(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        tableName=name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tableName+"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"time TEXT NOT NULL,"
                +"min TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(db);
    }
}
