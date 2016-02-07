package com.example.dns.leapfrog2;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dns.leapfrog2.module.Fragment2;
import com.example.dns.leapfrog2.module.FragmentExample;
import com.example.dns.leapfrog2.module.SignInFrag;
import com.example.dns.leapfrog2.module.SugnUpFrag;

public class FragmentActivityExample extends AppCompatActivity {

    boolean replacefrag = true;

    Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activity_example);
        initres();
        signIn.setOnClickListener(clickToView);
        signUp.setOnClickListener(clickToView);

        signIn.performClick();
    }

    View.OnClickListener clickToView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.signInButton) {
                signIn.setTextColor(Color.parseColor("#a188f0"));
                signUp.setTextColor(Color.parseColor("#a2a2bb"));
                addFragment(new SignInFrag());
            }
            if(v.getId() == R.id.signUpButton){
                signUp.setTextColor(Color.parseColor("#a188f0"));
                signIn.setTextColor(Color.parseColor("#a2a2bb"));
                addFragment(new SugnUpFrag());
            }
        }
    };

    private void initres() {
        signIn = (Button)findViewById(R.id.signInButton);
        signUp = (Button)findViewById(R.id.signUpButton);
    }

    public void addFragment(Fragment choosefrag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragin, choosefrag);
        ft.commit();
    }
}
