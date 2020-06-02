package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeleccionarArea extends AppCompatActivity {

    private ListView lista_areas;
    private String[] opciones_area;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_area);

        lista_areas = findViewById(R.id.lstAreas);
        opciones_area = getResources().getStringArray(R.array.opciones_area);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones_area);
        lista_areas.setAdapter(adapter);


    }
}
