package com.example.dns.leapfrog2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dns.leapfrog2.module.CustomArrayAdapter;
import com.example.dns.leapfrog2.module.UserInfo;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {

    //UserInfo user = new UserInfo();
    ListView customLV;

    //String[] customList = {"Ram", "Shyam", "Hari"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);


        initialisation();
        bindData();
    }

    private void bindData() {
        CustomArrayAdapter CAA = new CustomArrayAdapter(this, R.layout.single_row, fillArrayList());
        customLV.setAdapter(CAA);
    }

    private void initialisation() {
        customLV = (ListView)findViewById(R.id.customListView);
    }

    private ArrayList<UserInfo> fillArrayList() {
        ArrayList<UserInfo> customList = new ArrayList<>();
        customList.add(new UserInfo("Dinesh", "Android Develop", R.mipmap.dnes));
        customList.add(new UserInfo("Subash", "CMS Manager", R.mipmap.meme));
        customList.add(new UserInfo("Dheeraj", "Linux", R.mipmap.meme));
        customList.add(new UserInfo("Swekchya", "Content Writer", R.mipmap.meme));
        customList.add(new UserInfo("Manoj", "Graphics Designer", R.mipmap.meme));
        return customList;
    }
}

