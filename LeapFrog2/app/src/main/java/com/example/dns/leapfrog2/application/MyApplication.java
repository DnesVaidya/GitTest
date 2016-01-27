package com.example.dns.leapfrog2.application;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by Dns on 1/26/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initfonts();
    }

    public static class Fonts {
        public static Typeface fontIcons;

    }

    private void initfonts(){
        Fonts.fontIcons = Typeface.create(Typeface.createFromAsset(getAssets(),"font_new.ttf"),Typeface.NORMAL);
    }
}
