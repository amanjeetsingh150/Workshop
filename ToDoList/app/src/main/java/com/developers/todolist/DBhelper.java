package com.developers.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amanjeet Singh on 29-Jan-17.
 */

public class DBhelper extends SQLiteOpenHelper {
    private static final String DBNAME="todo.db";
    private static final int DBVERSION=1;
    private static final String TABLENAME="todotable";
    public DBhelper(Context context) {
        super(context,DBNAME,null,DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       final String SQL_CREATE_TABLE_TODO="CREATE TABLE "+TABLENAME+" (" +
                                           "id INTEGER PRIMARY KEY, "+
                                           "TITLE TEXT NOT NULL, "+
                                            "DESC TEXT NOT NULL"+" );";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String title,String description){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("TITLE",title);
        contentValues.put("DESC",description);
        sqLiteDatabase.insert(TABLENAME,null,contentValues);
        return true;
    }
    public Cursor getData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * from "+TABLENAME,null);
        res.moveToFirst();
        return res;
    }
}
