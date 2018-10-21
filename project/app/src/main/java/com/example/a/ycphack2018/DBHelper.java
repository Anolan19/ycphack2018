package com.example.a.ycphack2018;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.InputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "listing_and_accounts_DB.db";
    private static final String COLUMN_ID = "_id";
    //listings terms
    private static final String TABLE_LISTINGS = "listings";
    private static final String COLUMN_LISTINGNAME = "listingname";
    private static final String COLUMN_LISTINGOBJ = "listingobject";
    private static final String COLUMN_LISTINGPRIV = "listingprivacy";
    //accounts terms
    private static final String TABLE_ACCOUNTS = "accounts";
    private static final String COLUMN_ACCOUNTNAME = "accountname";
    private static final String COLUMN_ACCOUNTOBJ = "accountobject";

    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE listings( _id INTEGER PRIMARY KEY, listingname TEXT, " +
                "listingobject BLOB, listingprivacy INTEGER )");
        db.execSQL("CREATE TABLE accounts( _id INTEGER PRIMARY KEY, accountname TEXT, " +
                "accountobject BLOB )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS listings");
        db.execSQL("DROP TABLE IF EXISTS accounts");
        onCreate(db);
    }

    public void addListing(listing newListing)
    {   ContentValues values = new ContentValues();
        values.put(COLUMN_ID, newListing.getKey());
        values.put(COLUMN_LISTINGNAME, newListing.getTitle());
        values.put(COLUMN_LISTINGOBJ, this.writeListing(newListing));
        values.put(COLUMN_LISTINGPRIV, newListing.checkPrivate());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_LISTINGS, null, values);
        db.close();
    }

    public listing getListing(int key)
    {   String query = "SELECT * FROM " + TABLE_LISTINGS + " WHERE " +
                COLUMN_ID + " = \"" + key + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst())
            return readListing(cursor.getBlob(2));
        else return null;
    }

    private byte[] writeListing(listing myListing)//convert a listing to a byte array, or blob
    {   //called by addListing to store a listing in an SQLite table
        try
        {    ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(myListing);
            out.close();
            byte[] serialized_listing = bos.toByteArray();
            return serialized_listing;
        } catch (IOException e)
        {    System.out.println("IOException");
        }
        return null;
    }

    private listing readListing(byte[] myBlob)  //convert a byte array or blob into a listing
    {   //called by getListing to retrieve a listing stored in an SQLite table
        try
        {   ByteArrayInputStream bis = new ByteArrayInputStream(myBlob);
            ObjectInputStream is = new ObjectInputStream(bis);
            return (listing) is.readObject();
        } catch (IOException e)
        {    System.out.println("IOException");
        } catch (ClassNotFoundException e)
        {    System.out.println("ClassNotFoundException");
        }
        return null;
    }

    public void addAccount(account newAccount)      //store an account obj in database
    {   ContentValues values = new ContentValues();
        values.put(COLUMN_ID, newAccount.getKey());
        values.put(COLUMN_ACCOUNTNAME, newAccount.getName());
        values.put(COLUMN_ACCOUNTOBJ, this.writeAccount(newAccount));
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ACCOUNTS, null, values);
        db.close();
    }

    public account getAccount(int key)              //retrieve an account obj from database
    {   String query = "SELECT * FROM " + TABLE_ACCOUNTS + " WHERE " +
                COLUMN_ID + " = \"" + key + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst())
            return readAccount(cursor.getBlob(2));
        else return null;
    }

    private byte[] writeAccount(account myAccount)//convert an account to a byte array, or blob
    {   //called by addAccount to store an account in an SQLite table
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(myAccount);
            oos.close();
            byte[] serialized_account = bos.toByteArray();
            return serialized_account;
        } catch (IOException e)
        {    System.out.println("IOException");
        }
        return null;
    }

    private account readAccount(byte[] myBlob)  //convert a byte array or blob into an account
    {   //called by getAccount to retrieve an account stored in an SQLite table
        try
        {   ByteArrayInputStream bis = new ByteArrayInputStream(myBlob);
            ObjectInputStream is = new ObjectInputStream(bis);
            return (account) is.readObject();
        } catch (IOException e)
        {   System.out.println("IOException");
        } catch (ClassNotFoundException e)
        {    System.out.println("ClassNotFoundException");
        }
        return null;
    }
    public ArrayList<listing> findListing(String searchTerm)
    {   ArrayList<listing> returnArray = new ArrayList<listing>();
        String query = "SELECT * FROM " + TABLE_LISTINGS + " WHERE " +
                COLUMN_LISTINGNAME + " = \"" + searchTerm + "\" AND " +
                COLUMN_LISTINGPRIV + " = 0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if ( cursor.getCount() > 0 )
        {    cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++)
            {   returnArray.add(this.readListing(cursor.getBlob(2)));
                cursor.moveToNext();
            }
        } else return null;
        return returnArray;
    }
}