//links to createaccount.xml
//launches from AccountTypeActivity when you request to make a creator account
package com.example.a.ycphack2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class CreatorAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);
    }
    public void onCreateAccount(View v) //called when user presses "createaccount" button
    {   //grab EditText objects & convert them to strings
        final EditText emailText = (EditText) findViewById(R.id.email);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        final EditText bioText = (EditText) findViewById(R.id.bio);
        final EditText displayNameText = (EditText) findViewById(R.id.displayname);
        String emailString = emailText.getText().toString();
        String passwordString = passwordText.getText().toString();
        String bioString = bioText.getText().toString();
        String displayNameString = displayNameText.getText().toString();

        if ( userVerify(emailString, passwordString) ) //if school portal verifies user
        {   Intent accountIntent = new Intent(this, HomeMenuActivity.class);
            account userAccount = new account(displayNameString, bioString, emailString,
                    null, null);
            //add the user account to the database
            startActivity(accountIntent);//go to HomeMenuActivity--your account dashboard
        }
        else; //display error message, "Not a recognized user/password combo" etc.
    }
    public boolean userVerify(String email, String password)
    {   /*
        verify the user through the school portal in the following ways:
        - check that the email is a legitimate school email connected to a school that uses our app
        - check that the email isn't already registered with an account
        - check that the email and password match
        */
        return true;
    }
}
