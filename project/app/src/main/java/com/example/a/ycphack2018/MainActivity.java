//links to activity_main.xml
//launches when you run the app for the first time; invites you to make/sign in 2 ur account
package com.example.a.ycphack2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onLogin(View v) //called when user presses "login" button
    {   Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        //go to LoginActivity, which has you sign in
    }
    public void onJoin(View v)  //called when user presses "newaccount" button
    {   Intent joinIntent = new Intent(MainActivity.this, AccountTypeActivity.class);
        startActivity(joinIntent);
    }   //go to AccountTypeActivity, which asks whether you want a creator or funder account
}
