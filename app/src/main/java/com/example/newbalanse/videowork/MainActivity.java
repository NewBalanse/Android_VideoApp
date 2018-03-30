package com.example.newbalanse.videowork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_login;
    TextView txt_name;
    TextView txt_mail;

    //Intent MainIntent;
    SqlHelper SqlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name = findViewById(R.id.txt_nameMain);
        txt_mail = findViewById(R.id.txt_mailMain);
        txt_login = findViewById(R.id.txt_loginMain);

        if (getIntent().getSerializableExtra("UserData") != null)
            SqlData = ((SqlHelper) getIntent().getSerializableExtra("UserData"));

        if (SqlData != null) {

            txt_login.setText(SqlData.getLogin());
            txt_mail.setText(SqlData.getMail());
            String name = SqlData.getName() + " " + SqlData.getLastName();
            txt_name.setText(name);
        }
    }
}
