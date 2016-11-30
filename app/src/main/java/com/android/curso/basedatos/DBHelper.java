package com.android.curso.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ana.riquelme on 23/11/2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        db.execSQL(sqlCreate);
    }
}
