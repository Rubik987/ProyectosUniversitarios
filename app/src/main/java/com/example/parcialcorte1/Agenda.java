package com.example.parcialcorte1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Agenda extends AppCompatActivity {
    private TextView txt_nombre;
    private TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        txt_nombre = (TextView) findViewById(R.id.txt_nombre);
        txt2 = (TextView) findViewById(R.id.txt2);

        String nombre = getIntent().getStringExtra("nombre");
        String telefono = getIntent().getStringExtra("telefono");
        txt_nombre.setText(nombre);
        txt2.setText(telefono);
    }

    public void Regresar (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
