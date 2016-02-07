package com.example.dns.leapfrog2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuListActivity extends AppCompatActivity {

    ListView menulv;
    ArrayList<String> menuList = new ArrayList<String>(){
        {
            add("ListView Example");
            add("Data Pass From one Activity to Other");
            add("Custom List View");
            add("Style Example");
            add("Login View Practice");
            add("Custom Font Example");
            add("Fragment Example");
            add("PageViewer Activity");
            add("Material Design Tabs");
            add("Json Activity");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        initView();
        dataTogether();
        menulv.setOnItemClickListener(menuClick);
    }

    private void initView() {
        menulv = (ListView)findViewById(R.id.menuListView);
    }

    private void dataTogether() {
        ArrayAdapter<String> aadt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuList);
        menulv.setAdapter(aadt);
    }

    ListView.OnItemClickListener menuClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    Intent i = new Intent(MenuListActivity.this, ListActivity.class);
                    startActivity(i);
                    break;
                case 1:
                    Intent i1 = new Intent(MenuListActivity.this, LoginActivity.class);
                    startActivity(i1);
                    break;
                case 2:
                    Intent i2 = new Intent(MenuListActivity.this, CustomListView.class);
                    startActivity(i2);
                    break;
                case 3:
                    Intent i3 = new Intent(MenuListActivity.this, Style_Example.class);
                    startActivity(i3);
                    break;
                case 4:
                    Intent i4 = new Intent(MenuListActivity.this, LoginPractice1.class);
                    startActivity(i4);
                    break;
                case 5:
                    Intent i5 = new Intent(MenuListActivity.this, Custom_Fonts.class);
                    startActivity(i5);
                    break;
                case 6:
                    Intent i6 = new Intent(MenuListActivity.this, FragmentActivityExample.class);
                    startActivity(i6);
                    break;
                case 7:
                    Intent i7 = new Intent(MenuListActivity.this, ViewPagerActivity.class);
                    startActivity(i7);
                    break;
                case 8:
                    Intent i8 = new Intent(MenuListActivity.this, MaterialDesignTabs.class);
                    startActivity(i8);
                    break;
                case 9:
                    Intent i9 = new Intent(MenuListActivity.this, JsonActivity.class);
                    startActivity(i9);
                    break;

            }
        }
    };
}
