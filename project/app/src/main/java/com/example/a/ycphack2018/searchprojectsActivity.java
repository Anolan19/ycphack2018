package com.example.a.ycphack2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class searchprojectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchprojects);
        final ArrayList<account> listofEvents= new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("listing").orderByChild("score").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> children = dataSnapshot.getChildren().iterator();
                while(children.hasNext()&&listofEvents.size()<30){
                    DataSnapshot childSnapshot = (DataSnapshot) children.next();
                    account a = (account) childSnapshot.getValue();
                    listofEvents.add(a);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            Log.i("DATABASECONNERR",databaseError.toString());
            }
        });

    }
}
