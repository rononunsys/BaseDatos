package com.android.curso.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by ana.riquelme on 23/11/2016.
 */

public class ConectionDB {
    private static final String DB_NAME = "pruebaDB.db";
    private static final int VERSION = 1;

    public static SQLiteDatabase getConectionQuery(Context context){
        DBHelper dataBase = new DBHelper(context,DB_NAME,null,VERSION);
        SQLiteDatabase db = dataBase.getReadableDatabase();
        return db;
    }

    public static SQLiteDatabase getConectionWrite(Context context){
        DBHelper dataBase = new DBHelper(context,DB_NAME,null,VERSION);
        SQLiteDatabase db = dataBase.getWritableDatabase();
        return db;
    }

    public static void insert(Context context, String sql){
        SQLiteDatabase db = getConectionWrite(context);
        db.beginTransaction();
        try{
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
            db.close();
        }
    }
}
