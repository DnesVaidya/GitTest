package com.example.dns.leapfrog2.module;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Dns on 1/31/2016.
 */
public class MyPageAdapter extends FragmentPagerAdapter {

    private List<String> lists;

    public MyPageAdapter(android.support.v4.app.FragmentManager fm, List<String> lists) {
        super(fm);
        this.lists = lists;

    }
    @Override
    public int getCount() {
        return this.lists.size();
    }

    @Override
    public Fragment getItem(int position) {
        String imageUrl = lists.get(position);
        return ImageDetailFrag.newInstance(imageUrl);
    }
}
