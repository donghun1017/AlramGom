package com.donghun2017.alramgom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class PageAdapter extends FragmentPagerAdapter {

    Fragment[] frgs = new Fragment[3];
    String[] titles = new String[]{"기상알람", "수면알람", "빗소리"};

    public PageAdapter(FragmentManager fm) {
        super(fm);

        frgs[0] = new Tab1Fragment();
        frgs[1] = new Tab2Fragment();
        frgs[2] = new Tab3Fragment();


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
