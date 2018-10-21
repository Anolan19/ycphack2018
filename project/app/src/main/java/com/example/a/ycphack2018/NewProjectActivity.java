package com.example.a.ycphack2018;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NewProjectActivity extends AppCompatActivity {

    int emailString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        emailString = getIntent().getExtras().getInt("email");
        setContentView(R.layout.newproject);
    }

    public void onMakeProject(View v)//called when user presses "searchprojects" button
    {   Intent madeProject = new Intent(this, searchprojectsActivity.class);
        madeProject.putExtra("email", emailString);

        DBHelper db = new DBHelper(this,null,null,4);
        String title = ((EditText) findViewById(R.id.projecttitle) ).getText().toString();
        String descPrivate = ((EditText) findViewById(R.id.privatedescription) ).getText().toString();
        String descShort = ((EditText) findViewById(R.id.shortdescription) ).getText().toString();
        ImageView img = (ImageView) findViewById(R.id.icon);


        account projectCreator = db.getAccount(emailString);
        listing newlisting = new listing(title,projectCreator,descPrivate,descShort,null);
        db.addListing(newlisting);
        startActivity(madeProject);
        //go to searchprojectsActivity, where user can search thru all projects in database
    }
}
