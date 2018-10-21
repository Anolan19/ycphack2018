package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class searchprojectsActivity extends AppCompatActivity
{

    DBHelper db;
    EditText searchBar;
    //ArrayList<TextView> results;
    TextView result1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.searchprojects);

        db = new DBHelper(this,null,null,0);
        searchBar = (EditText) findViewById(R.id.searchBar);
        result1 = (TextView) findViewById(R.id.result1);

        //ArrayList<listing> projectsList = db.findListing("");
    }

    public void lookupProject(View v)
    {   String searchTerm = searchBar.getText().toString();
        ArrayList<listing> projectsList = db.findListing(searchTerm);
        if ( projectsList == null ) return;
        result1.setText(projectsList.get(0).getTitle());
    }
}
