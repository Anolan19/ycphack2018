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

    public void onMakeProject(View v)//called when user presses "createproject" button
    {   Intent madeProject = new Intent(this, HomeMenuActivity.class);
        madeProject.putExtra("email", emailString);

        DBHelper db = new DBHelper(this,null,null,4);
        String title = ( (EditText) findViewById(R.id.projecttitle) ).getText().toString();
        String descPrivate = ( (EditText) findViewById(R.id.privatedescription) ).getText().toString();
        String descShort = ( (EditText) findViewById(R.id.shortdescription) ).getText().toString();
        Bitmap icon = ( (BitmapDrawable)
                findViewById(R.id.icon).getResources().getDrawable(0,null) ).getBitmap();

        account listerAccount = db.getAccount(emailString);
        listing newListing = new listing(title,listerAccount,descPrivate,descShort, icon);
        db.addListing(newListing);
        startActivity(madeProject);
        //go back to HomeMenuActivity for now
    }
}
