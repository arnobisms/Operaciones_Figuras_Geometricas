package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeleccionarVolumen extends AppCompatActivity {

    private ListView lista_volumenes;
    private String[] opciones_volumen;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_volumen);

        lista_volumenes = findViewById(R.id.lstVolumenes);
        opciones_volumen = getResources().getStringArray(R.array.opciones_volumen);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones_volumen);
        lista_volumenes.setAdapter(adapter);
        lista_volumenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:
                      intent = new Intent(SeleccionarVolumen.this, SeleccionarVolumenEsfera.class);
                      startActivity(intent);
                        break;

                    case 1:
                      intent = new Intent(SeleccionarVolumen.this, SeleccionarVolumenCilindro.class);
                      startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(SeleccionarVolumen.this, SeleccionarVolumenCono.class);
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(SeleccionarVolumen.this, SeleccionarVolumenCubo.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
