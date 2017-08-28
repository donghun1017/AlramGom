package com.donghun2017.alramgom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class PageAdapter extends FragmentPagerAdapter {

    Fragment[] frgs = new Fragment[2];
    String[] titles = new String[]{"알람", "마음"};

    public PageAdapter(FragmentManager fm) {
        super(fm);

        frgs[0] = new Tab1Fragment();
        frgs[1] = new Tab2Fragment();


    }

    @Override
    public Fragment getItem(int position) {
        return frgs[position];
    }

    @Override
    public int getCount() {
        return frgs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
