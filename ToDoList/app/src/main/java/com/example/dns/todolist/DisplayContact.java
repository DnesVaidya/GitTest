package com.example.dns.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dns.todolist.Extra.DBHelper;

public class DisplayContact extends AppCompatActivity {

    public DBHelper mydb;

    EditText name;
    EditText phone;
    EditText email;
    EditText street;
    EditText place;
    Button addBtn;

    String lname, lphone, lemail, lstreet, lplace;

    int id_to_update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        initialisation();
        mydb = new DBHelper(this);

        addBtn.setOnClickListener(saveList);
    }

    private void initialisation() {
        name = (EditText) findViewById(R.id.editTextName);
        phone = (EditText) findViewById(R.id.editTextPhone);
        email = (EditText) findViewById(R.id.editTextStreet);
        street = (EditText) findViewById(R.id.editTextEmail);
        place = (EditText) findViewById(R.id.editTextCity);
        addBtn = (Button) findViewById(R.id.button1);
    }

    View.OnClickListener saveList = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            lname = name.getText().toString();
            lphone = phone.getText().toString();
            lemail = email.getText().toString();
            lstreet = street.getText().toString();
            lplace = place.getText().toString();

            if (lname.isEmpty() || lphone.isEmpty()) {
                Toast.makeText(DisplayContact.this, "Please fill the form correctly", Toast.LENGTH_LONG).show();
            } else {
                if (mydb.insertContacts(lname, lphone, lemail, lstreet, lplace)) {
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed To Saved", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    };
}
