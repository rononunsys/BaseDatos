package com.android.curso.basedatos;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText editText = (EditText) findViewById(R.id.edittext);
        Button save = (Button) findViewById(R.id.save);
        TextView text = (TextView) findViewById(R.id.text);

        final SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        String valor = preferences.getString("valorPrueba","");
        text.setText(valor);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor = editText.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("valorPrueba",valor);
                editor.commit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
