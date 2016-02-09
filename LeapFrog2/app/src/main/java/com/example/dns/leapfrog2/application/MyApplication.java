package com.example.dns.leapfrog2.application;

import android.app.Application;
import android.graphics.Typeface;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Dns on 1/26/2016.
 */
public class MyApplication extends Application {

    public static RequestQueue queue;


    public void onCreate() {
        super.onCreate();
        initfonts();
        init();
    }

    public static class Fonts {
        public static Typeface fontIcons;

    }

    private void initfonts(){
        Fonts.fontIcons = Typeface.create(Typeface.createFromAsset(getAssets(),"font_new.ttf"),Typeface.NORMAL);
    }

    public void init(){
        queue = Volley.newRequestQueue(this);
    }
}
