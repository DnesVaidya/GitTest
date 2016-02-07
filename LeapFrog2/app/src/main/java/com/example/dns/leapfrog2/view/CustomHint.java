package com.example.dns.leapfrog2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.dns.leapfrog2.application.MyApplication;

/**
 * Created by Dns on 1/28/2016.
 */
public class CustomHint extends EditText {
    public CustomHint(Context context) {
        super(context);
        setfont();
    }

    public CustomHint(Context context, AttributeSet attrs) {
        super(context, attrs);
        setfont();
    }

    public CustomHint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setfont();
    }

    public void setfont() {
        setTypeface(MyApplication.Fonts.fontIcons);
    }
}
