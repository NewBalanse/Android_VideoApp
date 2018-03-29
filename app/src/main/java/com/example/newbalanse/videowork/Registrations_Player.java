package com.example.newbalanse.videowork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrations_Player extends AppCompatActivity {

    Intent RegistrationPlayerIntent;
    Button btn_save;

    EditText _login;
    EditText _mail;
    EditText _name;
    EditText _LastName;

    String RoleUser;

    SqlHelper SqlData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrations__player);
        //set intent role user
        if ((getIntent().getSerializableExtra("RoleUser")) != null)
            RoleUser = ((String) getIntent().getSerializableExtra("RoleUser"));

        btn_save = findViewById(R.id.button_save);
        //edit list set
        _login = findViewById(R.id.edit_login);
        _mail = findViewById(R.id.edit_mail);
        _name = findViewById(R.id.edit_name);
        _LastName = findViewById(R.id.edit_lastName);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrationPlayerIntent = new Intent(getApplicationContext(),MainActivity.class);

                SqlData = new SqlHelper(
                        RoleUser,
                        _login.getText().toString(),
                        _mail.getText().toString(),
                        _name.getText().toString(),
                        _LastName.getText().toString()
                );


                startActivity(RegistrationPlayerIntent);
            }
        });
    }
}
