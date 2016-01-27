package com.example.dns.leapfrog2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DataPassActivity extends AppCompatActivity {

    EditText unEditText, pwEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pass);

        /* Intent intent = getIntent();

        String userName = intent.getExtras().getString("username");
        String passWord = intent.getExtras().getString("password");

        initialisation();

        unEditText.setText(userName);
        pwEditText.setText(passWord); */

        Bundle b = getIntent().getExtras();
        String userName = b.getString("username");
        String password = b.getString("password");

        initialisation();

        unEditText.setText(userName);
        pwEditText.setText(password);

    }

    private void initialisation() {
        unEditText = (EditText)findViewById(R.id.userNameEditText);
        pwEditText = (EditText)findViewById(R.id.pwEditText);
    }
}
