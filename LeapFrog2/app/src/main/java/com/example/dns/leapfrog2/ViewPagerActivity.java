package com.example.dns.leapfrog2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.dns.leapfrog2.module.ImageDetailFrag;
import com.example.dns.leapfrog2.module.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends FragmentActivity {

    MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        List<String> fragments = getImage();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.viewpgr);
        pager.setAdapter(pageAdapter);
    }

    private List<String> getImage(){
        List<String> flist = new ArrayList<>();

        flist.add("http://premier-league.xyz/wp-content/uploads/2015/01/Chelsea-Football-Club-Logo-9.jpg");
        flist.add("http://cdn.images.express.co.uk/img/dynamic/67/590x/06s112eden1hSX-468839.jpg");
        flist.add("http://images.dailystar.co.uk/dynamic/58/photos/316000/111316.jpg");

        return flist;
    }
}
