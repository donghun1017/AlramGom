package com.donghun2017.alramgom;

/**
 * Created by alfo06-23 on 2017-08-09.
 */

public class ListViewItem2 {
    String Title;
    int TitleImg;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getTitleImg() {
        return TitleImg;
    }

    public void setTitleImg(int titleImg) {
        TitleImg = titleImg;
    }

    public ListViewItem2(String title, int titleImg) {
        Title = title;
        TitleImg = titleImg;

    }
}


