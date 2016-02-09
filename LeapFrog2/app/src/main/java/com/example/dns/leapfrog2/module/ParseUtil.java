package com.example.dns.leapfrog2.module;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Dns on 2/9/2016.
 */
public class ParseUtil {

    public static ArrayList<Contact> parseContact(JSONObject obj){
        ArrayList<Contact> list = new ArrayList<>(obj.length());

        try{
            JSONArray contacts = obj.getJSONArray("contacts");
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject jobj = contacts.getJSONObject(i);

                String id = jobj.optString("id").toString();
                String name = jobj.optString("name").toString();
                String email = jobj.optString("email").toString();
                String address = jobj.optString("address").toString();
                String gender = jobj.optString("gender").toString();
                String mobile = jobj.optString("mobile").toString();
                String home = jobj.optString("home").toString();
                String office = jobj.optString("office").toString();

                list.add(new Contact(id, name, email, address, gender, mobile, home, office));
            }
        }
        catch (JSONException ex){
            ex.printStackTrace();
        }
        return list;
    }
}
