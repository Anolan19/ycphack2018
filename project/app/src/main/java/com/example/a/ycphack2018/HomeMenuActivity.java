package com.example.a.ycphack2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemenu);
    }
    public void onMyProjectsPortal(View v) //called when user presses "myprojects" button
    {   Intent myProjectsIntent = new Intent(this, MyProjectsActivity.class);
        startActivity(myProjectsIntent);
    }
    public void onNewProjectPortal(View v) //called when user presses "newproject" button
    {   Intent newProjectIntent = new Intent(this, NewProjectActivity.class);
        startActivity(newProjectIntent);
    }
    public void onSearchProjectsPortal(View v)//called when user presses "searchprojects" button
    {   Intent searchProjectsIntent = new Intent(this, searchprojectsActivity.class);
        startActivity(searchProjectsIntent);
    }
    public void onEditProfilePortal(View v) //called when user presses "viewprofile" button
    {   Intent editProfileIntent = new Intent(this, EditProfileActivity.class);
        startActivity(editProfileIntent);
    }
}
