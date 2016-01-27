package com.example.dns.leapfrog2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView userTextView, passTextView;
    Button submitButton, loginButton;
    EditText userEditText, passEditText;
    String userName, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        submitButton = (Button)findViewById(R.id.submitButton);
        loginButton = (Button)findViewById(R.id.loginButton);

        submitButton.setOnClickListener(submitAction);
        loginButton.setOnClickListener(submitAction);

        userEditText = (EditText)findViewById(R.id.userEditText);
        passEditText = (EditText)findViewById(R.id.passEditText);
    }

    View.OnClickListener submitAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.submitButton) {
                //Toast.makeText(MainActivity.this,"Submit Button Clicked",Toast.LENGTH_LONG).show();
                // Value pass by intent
                /* Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                initView();
                userName = userEditText.getText().toString();
                passWord = passEditText.getText().toString();

                intent.putExtra("username", userName);
                intent.putExtra("password", passWord);

                startActivity(intent); */

                //value pass using Bundle
                initView();
                userName = userEditText.getText().toString();
                passWord = passEditText.getText().toString();

                if(userName.isEmpty() || passWord.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Either Username or Password Missing", Toast.LENGTH_LONG).show();
                }
                else {
                    Bundle b = new Bundle();
                    b.putString("username", userName);
                    b.putString("password", passWord);

                    Intent i = new Intent(LoginActivity.this, DataPassActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            }
            /*userName = userEditText.getText().toString();
            passWord = passEditText.getText().toString();
            Log.v("username", userName);
            Log.e("password", passWord); */

            if(v.getId() == R.id.loginButton) {
                Toast.makeText(LoginActivity.this, "Login Button Clicked", Toast.LENGTH_LONG).show();
            }
        }
    };
}
