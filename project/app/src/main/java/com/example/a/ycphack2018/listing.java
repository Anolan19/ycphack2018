package com.example.a.ycphack2018;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class listing implements Serializable
{

    public enum tag{UMD,YCP,WEB,DESIGN,ENGINEER,JAVA,C};
    private String title;
    private static int key;
    private account lister;
    private ArrayList<account> contributers;
    private String description;
    private String shortdes;
    private HashMap<account,String> ideaCat;
    private int score;
    private int outOf;
    private boolean isPrivate;
    private Bitmap icon;

    public listing(String title, account init, String disc, String shortdes, Bitmap pic)
    {
        this.title = title;
        this.lister=init;
        this.description=disc;
        this.shortdes=shortdes;
        this.icon=pic;
    }

    public String getTitle() { return this.title; }
    public int getKey() { return this.key; }

    public void makePrivate(){
        this.isPrivate=true;
    }

    public void addMember(account a){
        this.contributers.add(a);
    }

    public void removeMember(account a){
        this.contributers.remove(a);
    }

    public int[] getScore(){
        int[] i= new int[2];
        i[0]=this.score;
        i[1]=this.outOf;
        return i;
    }

    public void addVote( boolean b){
        this.outOf++;
        if(b){
            this.score++;
        }
    }

    public void changeVote(boolean b){
        /*
        if b is true, then the previous vote was down, and this will increase it. other it was up, and this will make it down
         */
        if(b){
            this.score+=2;
        } else{
            this.score-=2;
        }
    }

    public void changeDesc(String s){
        this.description=s;
    }

    public String getDesc(){
        return  this.description;
    }

    public String getShortdes(){
        return this.shortdes;
    }

    public String getIdea(account a){
        return ideaCat.get(a);
    }

    public void updateIdea(account a, String s){
        ideaCat.put(a,s);
        //dsfkgjidfsbgibriuegbuifebiu
    }



}
