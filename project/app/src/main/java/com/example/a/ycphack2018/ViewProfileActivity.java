package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ViewProfileActivity extends AppCompatActivity {

    int emailString;
    DBHelper db;
    account userAccount;
    EditText displayName;
    EditText userbio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        emailString = getIntent().getExtras().getInt("email");
        setContentView(R.layout.publicprofile);

        displayName = findViewById(R.id.displayname);
        userbio = findViewById(R.id.bio);
        db = new DBHelper(this,null,null,2092939);
        userAccount = db.getAccount(emailString);
        displayName.setText(userAccount.getName());
        userbio.setText(userAccount.getBio());
    }
}
