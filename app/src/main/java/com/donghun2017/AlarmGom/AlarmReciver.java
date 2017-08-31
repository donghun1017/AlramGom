package com.donghun2017.AlarmGom;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by alfo06-23 on 2017-08-25.
 */


public class AlarmReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
 
        Toast.makeText(context, new Date().toString(), Toast.LENGTH_SHORT).show();

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, AlarmReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 20, i, PendingIntent.FLAG_UPDATE_CURRENT);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10*1000, pendingIntent);
        }else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10*1000, pendingIntent);
        }else{
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10*1000, 10*1000, pendingIntent);
        }
    }
}