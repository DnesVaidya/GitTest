package com.example.dns.leapfrog2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    //Android Tutorial: ListView Part 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoMenuListActivity();
            }
        }, 3000);
    }

    private void gotoMenuListActivity() {
        Intent i = new Intent(MainActivity.this, MenuListActivity.class);
        startActivity(i);
        finish();
    }

}
