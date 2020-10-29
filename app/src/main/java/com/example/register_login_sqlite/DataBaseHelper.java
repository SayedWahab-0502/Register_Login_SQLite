package com.example.register_login_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public DataBaseHelper( Context context)
    {
        super(context,"RegisterLogin.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create Table wahab(username text,mail text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop Table if exists wahab");
    }


    public boolean insert(String Username,String mail,String password)  //inserting data
    {
       SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put("username",Username);
        contentValues.put("mail",mail);
        contentValues.put("password",password);

        long insrt = db.insert("wahab",null,contentValues);

        if (insrt==-1)    //-1 indicates already value present

            return false;

        else
            return true;
    }


    public Boolean checkmail(String email)
    {

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor=db.rawQuery("Select * from wahab where mail=?",new String[]{email});

        if (cursor.getCount()>0)

            return false;
        else
            return true;
    }


    public Boolean Loginmailpassword(String mail,String password)
    {

SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

Cursor cursor=sqLiteDatabase.rawQuery("Select * from wahab where mail=? and password=?",new String[] {mail,password});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


}
