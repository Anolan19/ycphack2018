package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewProjectActivity extends AppCompatActivity {

    String emailString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        emailString = getIntent().getExtras().getString("email");
        setContentView(R.layout.newproject);
    }
}
