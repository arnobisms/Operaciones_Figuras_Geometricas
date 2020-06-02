package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeleccionarVolumen extends AppCompatActivity {

    private ListView lista_volumenes;
    private String[] opciones_volumen;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_volumen);

        lista_volumenes = findViewById(R.id.lstVolumenes);
        opciones_volumen = getResources().getStringArray(R.array.opciones_volumen);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones_volumen);
        lista_volumenes.setAdapter(adapter);

    }
}
