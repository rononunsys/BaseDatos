package com.android.curso.basedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatabaseActivity extends AppCompatActivity {
    int code = 0;
    private EditText eNombre;
    private EditText eCode;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button insert = (Button) findViewById(R.id.insert);
        Button query = (Button) findViewById(R.id.query);
        Button update = (Button) findViewById(R.id.update);
        Button delete = (Button) findViewById(R.id.delete);
        text = (TextView) findViewById(R.id.text);
        eNombre = (EditText) findViewById(R.id.nombre);
        eCode = (EditText) findViewById(R.id.code);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = eNombre.getText().toString();
                String code = eCode.getText().toString();
                SQLiteDatabase db = ConectionDB.getConectionWrite(getApplicationContext());
                db.beginTransaction();
                try{
                    db.execSQL("INSERT INTO Usuarios (nombre,codigo) VALUES ('"+nombre+"',"+code+")");
                    //ContentValues values = new ContentValues();
                    //values.put("nombre",nombre);
                    //values.put("codigo",code);
                    //db.insert("Usuarios",null,values);
                    db.setTransactionSuccessful();
                }catch (SQLiteException e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                    db.close();
                }
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vNombre = eNombre.getText().toString();
                String data = "";
                SQLiteDatabase db = ConectionDB.getConectionQuery(getApplicationContext());
                Cursor cursor = db.rawQuery("SELECT * from Usuarios",null);
                //Cursor cursor = db.query("Usuarios",new String[]{"nombre","codigo"},"nombre=?",new String[]{vNombre},null,null,null);
                int columnName = cursor.getColumnIndex("nombre");
                int columnCode = cursor.getColumnIndex("codigo");
                while(cursor.moveToNext()){
                    String nombre = cursor.getString(columnName);
                    String code = cursor.getString(columnCode);
                    data += nombre + " " + code + "\n";
                }
                text.setText(data);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = eNombre.getText().toString();
                String code = eCode.getText().toString();
                SQLiteDatabase db = ConectionDB.getConectionWrite(getApplicationContext());
                db.beginTransaction();
                try{
                    db.execSQL("UPDATE Usuarios SET nombre='"+nombre+"' where codigo="+code);
//                    ContentValues values = new ContentValues();
//                    values.put("nombre",nombre);
//                    db.update("Usuarios",values,"codigo=?",new String[]{code});
                    db.setTransactionSuccessful();
                }catch (SQLiteException e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                    db.close();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = eCode.getText().toString();
                SQLiteDatabase db = ConectionDB.getConectionWrite(getApplicationContext());
                db.beginTransaction();
                try{
                    db.execSQL("DELETE FROM Usuarios WHERE code="+code);
                    //db.delete("Usuarios","code=?",new String[]{code});
                }catch (SQLiteException e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                    db.close();
                }
            }
        });
    }
}
