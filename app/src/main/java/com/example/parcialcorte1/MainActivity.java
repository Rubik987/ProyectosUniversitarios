package com.example.parcialcorte1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.ContextMenu;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText txt_nombre1, txt_telefono;
    private Button button4;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre1 = (EditText) findViewById(R.id.txt_nombre1);
        txt_telefono = (EditText) findViewById(R.id.txt_telefono);
        registerForContextMenu(txt_nombre1);
        registerForContextMenu(txt_telefono);
        button4 = (Button) findViewById((R.id.button4));
        ArrayList <String> Grupos = new ArrayList<>();
        Grupos.add("Familia");
        Grupos.add("Trabajo");
        Grupos.add("Amigo");
        Grupos.add("Ocasional");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_2,Grupos);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_nombre1.setText("");
                txt_telefono.setText("");
            }
        });
    }

    public void Guardar (View view) {
        Intent i = new Intent( this, Agenda.class);
        i.putExtra("nombre", txt_nombre1.getText().toString());
        i.putExtra("telefono", txt_telefono.getText().toString());
        startActivity(i);
        Toast.makeText(this, "Contacto agendado", Toast.LENGTH_SHORT).show();
    }

    public void Agenda (View view) {
        Intent i = new Intent( this, Agenda.class);
        startActivity(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()==R.id.txt_telefono)
        {
            menu.add(0, 911, 0, "Generar numero de telefono");
        }
        if (v.getId()==R.id.txt_nombre1)
        {
            menu.add(0, 912, 0, "Convertir en mayusculas");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 911:
                generateRadomPhone();
                break;
            case 912:
                txt_nombre1.setText(txt_nombre1.getText().toString().toUpperCase());
                break;
        }
        return super.onContextItemSelected(item);
    }

    private  void generateRadomPhone(){
        int num1;
        int set2, set3;
        int iniNum[]= {300,310,320};
        Random generator = new Random();
        num1 = generator.nextInt(2);
        set2 = generator.nextInt(799) + 100;
        set3 = generator.nextInt(7999) + 1000;
        txt_telefono.setText(""+iniNum[num1]+set2+set3);
    }
}
