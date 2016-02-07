package com.example.dns.leapfrog2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.dns.leapfrog2.module.GridViewFrag;
import com.example.dns.leapfrog2.module.MaterialDesignFrag;
import com.example.dns.leapfrog2.module.RecyclerViewFrag;
import com.example.dns.leapfrog2.module.ViewPageAdapter;

public class MaterialDesignTabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_material_design_tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFrag(new MaterialDesignFrag(getResources().getColor(R.color.colorAccent)), "CAT");
        adapter.addFrag(new GridViewFrag(), "DOG");
        adapter.addFrag(new RecyclerViewFrag(), "People");
        viewPager.setAdapter(adapter);
    }
}