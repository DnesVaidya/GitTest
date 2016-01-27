package com.example.dns.leapfrog2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    ArrayList<String> epl = new ArrayList<String>(){
        {
            add("Arsenal");
            add("Chelsea");
            add("Everton");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initialisation();
        bindData();
        lv.setOnItemClickListener(this);

    }

    private void initialisation() {
        lv = (ListView)findViewById(R.id.listView);
    }

    private void bindData() {
        ArrayAdapter<String> SAA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.EPL));
        lv.setAdapter(SAA);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String clickItem = (String) parent.getAdapter().getItem(position);
        Toast.makeText(ListActivity.this, "Position Click: " + position + "" + clickItem, Toast.LENGTH_LONG).show();
        }
    }

