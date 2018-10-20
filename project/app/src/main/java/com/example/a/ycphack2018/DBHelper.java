package com.example.a.ycphack2018;

import android.content.Context;
import android.view.View;


import java.io.File;
import java.io.InputStream;

public class DBHelper {

    private final String listingsfile= "listings.txt";
    private final String acctFile= "accounts.txt";

    public account getacc(String key, Context c) {
        //seeks through the text file to find the last  entry with the specified email.

/*
        account a;

        File path = c.getFilesDir();
        File file = new File(path,acctFile );
*/

        account a = null;

        try {
            InputStream i = c.openFileInput(acctFile);

        } catch (Exception e){

        }

        return a;

    }

    //the put into db appends a new line at the end file with all the needed info for the constructor


    //all entries take up one line, so that you can seek by line, using input streams and output streams

}

