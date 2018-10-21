package com.example.a.ycphack2018;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

enum Tag {susky, york, umd,webdev, business, science, SRE, HCI}

public class account implements Serializable
{
    private static final String databaseTAG = "server/accounts";

    private  int key;             //random unique key, for easy database access
    private String name;                //user name
    private String email;               //user email
    private int[] rating;               //user rating as a ratio of totalratings : totalmax
    private String bio;                 //self-inserted user bio
    private ArrayList<Integer> listings;    //listings user is in
    private ArrayList<Integer> ideas;       //listings user has created
    private Bitmap profilepic;
    private ArrayList<Tag> user_tags;

    public account(String name, String bio, String email, ArrayList<Tag> tags, Bitmap profilepic)
    {
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.user_tags = tags;
        this.profilepic = profilepic;
        this.key=email.hashCode();
    }

    public String getName() { return this.name; }
    public int getKey() { return this.key; }

    public void setBio(String newbio)
    {   this.bio = newbio;
    }
    public void setPfp(Bitmap newpfp)
    {   this.profilepic = newpfp;
    }

    public void addTag(Tag newtag)
    {   this.user_tags.add(newtag);
    }
    public void removeTag(Tag oldtag)
    {   this.user_tags.remove(oldtag);
    }
    public void addListing(listing newlisting)
    {   this.listings.add(newlisting.getKey());
    }
    public void removeListing(listing oldlisting)
    {   this.listings.remove(oldlisting);
    }
    public void addIdea(listing newIdea)        //tell the bros about this
    {   this.ideas.add(newIdea.getKey());                //also note lack of ability to remove ideas

        this.addListing(newIdea);
    }



}
