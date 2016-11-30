package com.android.curso.basedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button preference = (Button) findViewById(R.id.preference);
        Button ddbb = (Button) findViewById(R.id.basedatos);

        preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PreferenceActivity.class);
                startActivity(intent);
            }
        });

        ddbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DatabaseActivity.class);
                startActivity(intent);
            }
        });
    }
}
