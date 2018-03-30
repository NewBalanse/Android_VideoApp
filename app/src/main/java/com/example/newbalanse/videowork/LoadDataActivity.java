package com.example.newbalanse.videowork;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class LoadDataActivity extends AppCompatActivity {


    SQLiteDatabase database;
    Cursor db_Cursor;

    //SimpleCursorAdapter db_Adapter;

    Intent HeadIntent;
    Toast toast;
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

                try {
                    //select information user
                    db_Cursor = database.rawQuery("select * from user", null);

                    if (db_Cursor.getCount() > 0) {

                        db_Cursor.moveToFirst();
                        //set sqlData info for user
                        SqlData.setRoleUser(db_Cursor.getString(db_Cursor.getColumnIndex("role")));
                        SqlData.setLogin(db_Cursor.getString(db_Cursor.getColumnIndex("login")));
                        SqlData.setMail(db_Cursor.getString(db_Cursor.getColumnIndex("mail")));
                        SqlData.setName(db_Cursor.getString(db_Cursor.getColumnIndex("nameUser")));
                        SqlData.setLastName(db_Cursor.getString(db_Cursor.getColumnIndex("lastNameUser")));

                        //init intent and set the transmitted information
                        HeadIntent = new Intent(getApplicationContext(), MainActivity.class);
                        HeadIntent.putExtra("UserData", SqlData);
                    } else {
                        //just init intent
                        HeadIntent = new Intent(getApplicationContext(), CreateRoleActivity.class);
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

        SqlData = new SqlHelper();

        //Create database if database not exist
        database = getBaseContext().openOrCreateDatabase(
                "videoApp.db",
                MODE_PRIVATE,
                null);

        toast = Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT);
        toast.show();
        //init thread and start work thread's
      /*  Thread thread = new Thread(runnable);
        thread.start();*/

        SetHeadIntent();

        //end work the progressBar
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        startActivity(HeadIntent);
    }

    private void SetHeadIntent() {
        try {
            //select information user
            db_Cursor = database.rawQuery("select * from user", null);

            toast = Toast.makeText(getApplicationContext(), String.valueOf(db_Cursor.getCount()), Toast.LENGTH_SHORT);
            toast.show();

            if (db_Cursor.getCount() > 0) {

                db_Cursor.moveToFirst();
                //set sqlData info for user
                SqlData.setRoleUser(db_Cursor.getString(db_Cursor.getColumnIndex("role")));
                SqlData.setLogin(db_Cursor.getString(db_Cursor.getColumnIndex("login")));
                SqlData.setMail(db_Cursor.getString(db_Cursor.getColumnIndex("mail")));
                SqlData.setName(db_Cursor.getString(db_Cursor.getColumnIndex("nameUser")));
                SqlData.setLastName(db_Cursor.getString(db_Cursor.getColumnIndex("lastNameUser")));

                //init intent and set the transmitted information
                HeadIntent = new Intent(getApplicationContext(), MainActivity.class);
                HeadIntent.putExtra("UserData", SqlData);
            } else {
                //just init intent
                HeadIntent = new Intent(getApplicationContext(), CreateRoleActivity.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }
    }

}
