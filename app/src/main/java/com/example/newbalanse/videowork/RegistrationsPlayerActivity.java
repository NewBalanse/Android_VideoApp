package com.example.newbalanse.videowork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationsPlayerActivity extends AppCompatActivity {

    Intent RegistrationPlayerIntent;
    Button btn_save;

    EditText _login;
    EditText _mail;
    EditText _name;
    EditText _LastName;

    SqlHelper SqlData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrations__player);

        //set intent role user
        try {
            if ((getIntent().getSerializableExtra("UserData")) != null)
                SqlData = ((SqlHelper) getIntent().getSerializableExtra("UserData"));
            else
                SqlData = new SqlHelper();
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn_save = findViewById(R.id.button_save);
        //edit list set
        _login = findViewById(R.id.edit_login);
        _mail = findViewById(R.id.edit_mail);
        _name = findViewById(R.id.edit_name);
        _LastName = findViewById(R.id.edit_lastName);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RegistrationPlayerIntent = new Intent(getApplicationContext(), MainActivity.class);

                    if (SqlData != null) {
                        SqlData.setLogin(_login.getText().toString());
                        SqlData.setMail(_mail.getText().toString());
                        SqlData.setName(_name.getText().toString());
                        SqlData.setLastName(_LastName.getText().toString());
                    } else {
                        SqlData = new SqlHelper();
                    }

                    SqlData.SaveInformations(getBaseContext().openOrCreateDatabase("videoApp.db", MODE_PRIVATE, null));
                    RegistrationPlayerIntent.putExtra("UserData",SqlData);
                    
                    startActivity(RegistrationPlayerIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
