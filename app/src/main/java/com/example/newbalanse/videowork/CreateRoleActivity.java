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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_role);

        btn_player = findViewById(R.id.button_player);
        btn_watcher = findViewById(R.id.button_watcher);

        btn_watcher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainIntent = new Intent(getApplicationContext(),Registrations_Watcher.class);//поменять на активити регистрации зрителя

                startActivity(MainIntent);
            }
        });
        btn_player.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainIntent = new Intent(getApplicationContext(),Registrations_Player.class);//поменять на активити регистрации игрока

                startActivity(MainIntent);
            }
        });
    }
}
