package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewProjectActivity extends AppCompatActivity {

    int emailString;
    int projKey;
    DBHelper db;
    listing projectListing;
    EditText displayName;
    TextView projDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        emailString = getIntent().getExtras().getInt("email");
        projKey = getIntent().getExtras().getInt("key");
        setContentView(R.layout.publicproject);

        displayName = findViewById(R.id.displayname);
        projDesc = findViewById(R.id.bio);
        db = new DBHelper(this,null,null,2092939);
        projectListing = db.getListing(projKey);
        displayName.setText(projectListing.getTitle());
        projDesc.setText(projectListing.getDescription());//make this contingent on user perms
    }
}
