//links to accounttype.xml
//launches from MainActivity when you ask to create an account
package com.example.a.ycphack2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccountTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounttype);
    }
    public void onSelectCreatorAccount(View v) //called when user presses "creator" button
    {   Intent creatorIntent = new Intent(this, CreatorAccountActivity.class);
        startActivity(creatorIntent);
        //go to CreatorAccountActivity, which has you make your creator account
    }
    public void onSelectFundingAccount(View v)
    {   //this code would connect you to another activity,
        //for creating a funding account
    }
}
