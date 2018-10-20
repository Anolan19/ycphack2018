//links to homemenu.xml
//launches from CreatorAccountActivity when user creates account,
//or from LoginACtivity when user logs in
package com.example.a.ycphack2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeMenuActivity extends AppCompatActivity {

    String emailString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        emailString = getIntent().getExtras().getString("email");
        setContentView(R.layout.homemenu);
    }
    public void onMyProjectsPortal(View v) //called when user presses "myprojects" button
    {   Intent myProjectsIntent = new Intent(this, MyProjectsActivity.class);
        myProjectsIntent.putExtra("email", emailString);
        startActivity(myProjectsIntent);
        //go to MyProjectsActivity, & full list of projects the user's working on
    }
    public void onNewProjectPortal(View v) //called when user presses "newproject" button
    {   Intent newProjectIntent = new Intent(this, NewProjectActivity.class);
        newProjectIntent.putExtra("email", emailString);
        startActivity(newProjectIntent);
        //go to NewProjectActivity, where you can add a new listing
    }
    public void onSearchProjectsPortal(View v)//called when user presses "searchprojects" button
    {   Intent searchProjectsIntent = new Intent(this, searchprojectsActivity.class);
        searchProjectsIntent.putExtra("email", emailString);
        startActivity(searchProjectsIntent);
        //go to searchprojectsActivity, where user can search thru all projects in database
    }
    public void onEditProfilePortal(View v) //called when user presses "viewprofile" button
    {   Intent editProfileIntent = new Intent(this, EditProfileActivity.class);
        editProfileIntent.putExtra("email", emailString);
        startActivity(editProfileIntent);
        //go to EditProfileActivity, where user can change their profile
    }
}
