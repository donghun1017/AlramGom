package com.donghun2017.alramgom;

/**
 * Created by alfo06-23 on 2017-08-04.
 */

public class ListViewItem {
    String time;
    String week;
    String selectDay;
    String ring;
    boolean vibration;
    boolean silent;
    int clearImg;
    String memo;

    public ListViewItem(String time, String week, String selectDay, String ring, boolean vibration, boolean silent, int clearImg, String memo) {
        this.time = time;
        this.week = week;
        this.selectDay = selectDay;
        this.ring = ring;
        this.vibration = vibration;
        this.silent = silent;
        this.clearImg = clearImg;
        this.memo = memo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSelectDay() {
        return selectDay;
    }

    public void setSelectDay(String selectDay) {
        this.selectDay = selectDay;
    }

    public String getRing() {
        return ring;
    }

    public void setRing(String ring) {
        this.ring = ring;
    }

    public boolean isVibration() {
        return vibration;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
    }

    public boolean isSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public int getClearImg() {
        return clearImg;
    }

    public void setClearImg(int clearImg) {
        this.clearImg = clearImg;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}


