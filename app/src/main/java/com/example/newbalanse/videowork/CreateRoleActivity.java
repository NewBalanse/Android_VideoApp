package com.example.newbalanse.videowork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateRoleActivity extends AppCompatActivity {

    Button btn_player;
    Button btn_watcher;

    Intent MainIntent;
    SqlHelper SqlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_role);
        //set init button
        btn_player = findViewById(R.id.button_player);
        btn_watcher = findViewById(R.id.button_watcher);

        //init Intent manager
        try {
            if (getIntent().getSerializableExtra("UserData") != null)
                SqlData = ((SqlHelper) getIntent().getSerializableExtra("UserData"));
            else
                SqlData = new SqlHelper();
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn_watcher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainIntent = new Intent(getApplicationContext(), RegistrationsPlayerActivity.class);//поменять на активити регистрации зрителя
                SqlData.setRoleUser("Watcher");
                MainIntent.putExtra("UserData", SqlData);

                startActivity(MainIntent);
            }
        });
        btn_player.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainIntent = new Intent(getApplicationContext(), RegistrationsPlayerActivity.class);//поменять на активити регистрации игрока
                SqlData.setRoleUser("Player");
                MainIntent.putExtra("UserData", SqlData);

                startActivity(MainIntent);
            }
        });
    }
}
