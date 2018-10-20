package com.example.a.ycphack2018;

import android.graphics.Bitmap;

import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

enum School {susky, york, umd}
enum Tag {webdev, business, science, SRE, HCI}

public class account
{
    private static final String databaseTAG = "server/accounts";
    private String name;        //user name
    private int[] rating;       //user rating as a ratio of totalratings : totalmax
    private String bio;         //self-inserted user bio
    private Array listings;     //listings user is in
    private Bitmap profilepic;
    private School user_school;
    private ArrayList<Tag> user_tags;

    public account(String name, String bio, School school, ArrayList<Tag> tags, Bitmap profilepic)
    {
        this.name = name;
        this.bio = bio;
        this.user_school = school;
        this.user_tags = tags;
        this.profilepic = profilepic;
    }
    public void setBio(String bio)
    {   this.bio = bio;
    }
    public void setPfp(Bitmap newpfp)
    {   this.profilepic = newpfp;
    }
    public static account getFromDatabase(String key ){
        account a = FirebaseDatabase.getInstance().getReference(databaseTAG).;

                return a;
    }
}
