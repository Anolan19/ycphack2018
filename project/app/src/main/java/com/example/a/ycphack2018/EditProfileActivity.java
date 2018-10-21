package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

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
        setContentView(R.layout.editprofile);

        displayName = findViewById(R.id.displayname);
        userbio = findViewById(R.id.bio);
        db = new DBHelper(this,null,null,1);
        userAccount = db.getAccount(emailString);
        displayName.setText(userAccount.getName());
        userbio.setText(userAccount.getBio());
    }
}
