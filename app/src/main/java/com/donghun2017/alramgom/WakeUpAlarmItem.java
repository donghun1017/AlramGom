package com.donghun2017.alramgom;

/**
 * Created by alfo06-23 on 2017-08-01.
 */

public class WakeUpAlarmItem {
    boolean able;
    String time;
    String week;
    String ring;
    boolean vibration;
    boolean silent;
    int clear;
    int imgId;

    public WakeUpAlarmItem(boolean able, String time, String week, String ring, boolean vibration, boolean silent, int clear, int imgId) {
        this.able = able;
        this.time = time;
        this.week = week;
        this.ring = ring;
        this.vibration = vibration;
        this.silent = silent;
        this.clear = clear;
        this.imgId = imgId;
    }
}
