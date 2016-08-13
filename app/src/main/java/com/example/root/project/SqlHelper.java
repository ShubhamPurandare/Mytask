package com.example.root.project; /**
 * Created by root on 27/7/16.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;


public class SqlHelper extends  SQLiteOpenHelper {


    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "Shubham.db";
    public static final String TABLE_NAME= "First";
    public static final String id = "id";
    public static  String name = "name";
    public static  String username = "Username";
    public static  String password = "Password";


    public SqlHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.v("Test ", "Creating a table ");
            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +

                    name + " varchar(20) , " +
                    username + " varchar(20) , " +
                    password + " varchar(20) " +
                    ")";
            Log.v("Test ", "string successfully created");

            db.execSQL(query);
            Log.v("Test ", " Table created  ");

        }catch(Exception e){
            e.getMessage();
            Log.v("Test ", "Creating  table failed ...");

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // add a row
    public void addProducts(Reg reg){
        Log.v("1: ","In addProcucts function ");
        ContentValues values= new ContentValues();

        Log.v("2: ","Content values successfull !!! ");
        values.put(name, reg.getName1());
        Log.v("3: ", " Name value created !!!!!  ");

        values.put(username, reg.getUser1());
        Log.v("3: ", " UserName value created !!!!!  ");

        values.put(password, reg.getPass1());
        Log.v("3: ", " Password value created !!!!!  ");

       try {
           SQLiteDatabase db = getWritableDatabase();

        Log.v("4: ","Sqlite database object created!!!  ");
        db.insert(TABLE_NAME, null, values);

        Log.v("1: ", "Insert fucn successfull !! ");
        db.close();

        Log.v("1: ", "  Sqlite database object closed !");
       }catch(Exception e){
           e.getStackTrace();
           e.getMessage();
       }
    }


    public String toDatabase(){
        String dbString = null;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT NAME FROM "+ TABLE_NAME + " WHERE 1;";

        Cursor c= db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast()){

            if(c.getString(c.getColumnIndex("name"))!=null){
                    dbString+= c.getString(c.getColumnIndex("name"));
                dbString += " \n";
            }

        }
        db.close();
        return dbString;

    }


    public boolean ifExists(String TableName, String dBField, String  FieldValue ){

        Log.v("4: ","In ifexists func ");

        SQLiteDatabase sql = getReadableDatabase();

        Log.v("4: "," Sql obj Success");
        String Query = "SELECT * FROM "+ TableName + " WHERE " + dBField+" = " + FieldValue + " ; ";

        Log.v("4: "," Query string sucess");
        Cursor cursor = sql.rawQuery(Query,null);

        Log.v("4: ","Cursor obj success ");
        if (cursor.getCount() <= 0){
            cursor.close();

            Log.v("4: ", " Cursor closed and returned false value");
            return  false;

        }
        cursor.close();

        Log.v("4: ", " cursor closed and returned true value...");
        return true;

    }



}
