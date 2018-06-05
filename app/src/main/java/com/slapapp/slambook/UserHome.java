package com.slapapp.slambook;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by $ukesh $hetty on 30-04-2017.
 */

public class UserHome extends AppCompatActivity {


    private Button mWrite;
    private Button mRead;
    private Button mBirth;
    private Button mLogout;
    private  String emailFor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slam_home);
        Toast.makeText(UserHome.this,"Welcome to Home Activity",Toast.LENGTH_LONG);
//        android.app.ActionBar bar=getActionBar();
//        bar.setTitle("Slambook");
//        bar.setSubtitle("Know your friend");
        emailFor=getIntent().getStringExtra("emailFor");
        mWrite = (Button) findViewById(R.id.write);
        mWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeMemory();
            }
        });
        mRead = (Button) findViewById(R.id.read);
        mRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMemories();
            }
        });
        mBirth = (Button) findViewById(R.id.bday);
        mBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birthdayReminders();
            }
        });
        mLogout = (Button) findViewById(R.id.logout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }
    SharedPreferences sharedpreferences;
    private void logout() {
        Toast.makeText(UserHome.this,"LOGOUT",Toast.LENGTH_SHORT).show();
//        sharedpreferences = getSharedPreferences("SlamPref", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor= sharedpreferences.edit();
//        editor.putBoolean("isLogin",false);
//        editor.putString("logFor","");
//        editor.commit();
        Intent intent=new Intent(UserHome.this,LoginActivity.class);
        startActivity(intent);

    }

    private void birthdayReminders() {
        Toast.makeText(UserHome.this,"Birthday Reminders",Toast.LENGTH_SHORT).show();
        Log.e("UserHome:","BDay");
        Intent intent = new Intent(UserHome.this,BirthDayReminder.class);
        startActivity(intent);
    }

    private void readMemories() {
        Toast.makeText(UserHome.this,"Read Memories",Toast.LENGTH_SHORT).show();
        Log.e("UserHome:","Read");
        Intent intent = new Intent(UserHome.this,ReadData.class);
        startActivity(intent);
    }

    private void writeMemory() {
        Toast.makeText(UserHome.this,"Write A Memory",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(UserHome.this,WriteForm.class);
        intent.putExtra("emailFor",emailFor);
        startActivity(intent);
    }
}
