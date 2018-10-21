package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditProfileActivity extends AppCompatActivity {

    int emailString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        emailString = getIntent().getExtras().getInt("email");
        setContentView(R.layout.editprofile);
    }
}
