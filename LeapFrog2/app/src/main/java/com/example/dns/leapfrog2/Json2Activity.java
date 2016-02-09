package com.example.dns.leapfrog2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dns.leapfrog2.application.MyApplication;
import com.example.dns.leapfrog2.module.ApiParseJsonAdapter;
import com.example.dns.leapfrog2.module.Contact;
import com.example.dns.leapfrog2.module.JsonArrayAdapter;
import com.example.dns.leapfrog2.module.ParseUtil;
import com.squareup.picasso.Downloader;

import org.json.JSONObject;

import java.util.ArrayList;

public class Json2Activity extends AppCompatActivity {

    MyApplication ap = new MyApplication();
    ArrayList<Contact> list;
    ListView apiJsonLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json2);
        apiJsonLV = (ListView) findViewById(R.id.apiJsonLV);

        String jsonUrl = "http://api.androidhive.info/contacts/";
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, jsonUrl, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("response", "response");
                list= ParseUtil.parseContact(response);
                getDataTogether();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("error", "error");
                    }
                });
        //add request to queue
        if(checkNetwork()){
            ap.queue.add(req);
        }
        else {
            Toast.makeText(Json2Activity.this, "No Internet Access", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean checkNetwork(){
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni !=null && ni.isConnected();
    }

    private void getDataTogether(){
        ApiParseJsonAdapter jaa = new ApiParseJsonAdapter(this, R.layout.apijson, list);
        apiJsonLV.setAdapter(jaa);
    }
}

