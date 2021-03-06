package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeleccionarArea extends AppCompatActivity {

    private ListView lista_areas;
    private String[] opciones_area;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_area);

        lista_areas = findViewById(R.id.lstAreas);
        opciones_area = getResources().getStringArray(R.array.opciones_area);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones_area);
        lista_areas.setAdapter(adapter);
        lista_areas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        intent = new Intent(SeleccionarArea.this, SeleccionarAreaCuadrado.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(SeleccionarArea.this, SeleccionarAreaRectangulo.class);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(SeleccionarArea.this, SeleccionarAreaTriangulo.class);
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(SeleccionarArea.this, SeleccionarAreaCirculo.class);
                        startActivity(intent);
                        break;
                }
            }
        });


    }
}
