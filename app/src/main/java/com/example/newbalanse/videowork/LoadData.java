package com.example.newbalanse.videowork;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

public class LoadData extends AppCompatActivity {

    SQLiteDatabase database;
    Cursor db_Cursor;

    //SimpleCursorAdapter db_Adapter;

    Intent HeadIntent;
    SqlHelper SqlData;
    ProgressBar progressBar;

    //String[] _options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SqlData = new SqlHelper();

                //Create database if database not exist
                database = getBaseContext().openOrCreateDatabase(
                        "videoApp.db",
                        MODE_PRIVATE,
                        null);
                try {
                    //create table if null
                    SqlData.CreateTableUser(database);
                    //select information user
                    db_Cursor = database.rawQuery("select * from user", null);

                    if (db_Cursor.getCount() > 0) {

                        /*_options = new String[]{
                                "role",
                                "login",
                                "mail",
                                "nameUser",
                                "lastNameUser"
                        };*/
                        db_Cursor.moveToFirst();
                        //set sqlData info for user
                        SqlData.setRoleUser(db_Cursor.getString(db_Cursor.getColumnIndex("role")));
                        SqlData.setLogin(db_Cursor.getString(db_Cursor.getColumnIndex("login")));
                        SqlData.setMail(db_Cursor.getString(db_Cursor.getColumnIndex("mail")));
                        SqlData.setName(db_Cursor.getString(db_Cursor.getColumnIndex("nameUser")));
                        SqlData.setLastName(db_Cursor.getString(db_Cursor.getColumnIndex("lastNameUser")));

                        //init intent and set the transmitted information
                        HeadIntent = new Intent(getBaseContext(),MainActivity.class);
                        HeadIntent.putExtra("UserData",SqlData);
                    } else {
                        //just init intent
                        HeadIntent = new Intent(getBaseContext(), CreateRoleActivity.class);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    database.close();
                }

            }
        };

        progressBar = findViewById(R.id.progressBar);

        //set visible and run progressBar
        progressBar.setVisibility(ProgressBar.VISIBLE);

        //init thread and start work thread's
        Thread thread = new Thread(runnable);
        thread.start();
        //end work the progressBar
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        startActivity(HeadIntent);
    }

}
