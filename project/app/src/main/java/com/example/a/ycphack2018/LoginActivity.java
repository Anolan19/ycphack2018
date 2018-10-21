//links to login.xml
//launches from MainActivity when you ask to log in 2 ur account
package com.example.a.ycphack2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void onLogin(View v)
    {   //grab EditText objects and convert them to strings
        final EditText emailText = (EditText) findViewById(R.id.email);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        String emailString = emailText.getText().toString();
        String passwordString = passwordText.getText().toString();

        if ( loginVerify(emailString, passwordString) )//if we verify the user
        {   Intent loginIntent = new Intent(this, HomeMenuActivity.class);
        loginIntent.putExtra("email",emailString.hashCode());
            startActivity(loginIntent);
        }   //go to HomeMenuActivity--your account dashboard
    }
    public boolean loginVerify(String email, String password)
    {   //check that the password is correct and the email matches an account in our database
        DBHelper b = new DBHelper(this,null,null,-1);
        Log.i("Y@Y@IYG@G@UVUG@VKU@VGU","made db connection");

        account a = b.getAccount(email.hashCode());
        Log.i("Y@Y@IYG@G@UVUG@VKU@VGU","Got the account from the db");
        if(a==null){
            Toast.makeText(this, "Invalid login information!", Toast.LENGTH_SHORT).show();

            return false;

        } else{

            return true;
        }
    }
}
