package com.example.dns.leapfrog2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dns.leapfrog2.module.Fragment2;
import com.example.dns.leapfrog2.module.FragmentExample;

public class FragmentActivityExample extends AppCompatActivity {

    boolean replacefrag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activity_example);
        if(replacefrag) {
            addFragment(new FragmentExample());
        }
        else {
            addFragment(new Fragment2());
        }
    }

    public void addFragment(Fragment choosefrag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragin, choosefrag);
        ft.commit();
    }
}
