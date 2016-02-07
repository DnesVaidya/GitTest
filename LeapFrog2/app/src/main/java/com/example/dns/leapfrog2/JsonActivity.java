package com.example.dns.leapfrog2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dns.leapfrog2.module.CustomArrayAdapter;
import com.example.dns.leapfrog2.module.EmployeeJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity {

    ListView jsonList;
    ArrayList<EmployeeJson> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        jsonList = (ListView)findViewById(R.id.jsonListView);
        String jsonData = loadJson();
        try {
            JSONObject jsonRootObj = new JSONObject(jsonData);
            JSONArray employee = jsonRootObj.getJSONArray("employee");
            list = new ArrayList<>(employee.length());

            for (int i = 0; i < employee.length(); i++) {
                JSONObject jsonObject = employee.getJSONObject(i);

                String ename = jsonObject.optString("name").toString();
                String jobTitle = jsonObject.optString("jobtitle").toString();

                list.add(new EmployeeJson(ename, jobTitle));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        bindData();

    }


    public String loadJson() {
        String json = null;
        try{
            InputStream is = getAssets().open("employee.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return json;
    }

    private void bindData() {
        ArrayAdapter CAA = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        jsonList.setAdapter(CAA);
    }
}
