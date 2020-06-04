package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarVolumenEsfera extends AppCompatActivity {

    private EditText radio_esfera;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_volumen_esfera);
        radio_esfera = findViewById(R.id.txtRadioEsfera);
        resultado = findViewById(R.id.lblResultadoVolumenEsfera);
        radio_esfera.requestFocus();
    }

    public void calcular(View v){
        Double radio, res;
        Operacion op;
        String msj_radio;


        if(validar()){

            radio = Double.parseDouble(radio_esfera.getText().toString());
            res = (4 * 3.1416 * radio * radio * radio)/3;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_volumen_de_esfera), getString(R.string.msj_radio)+radio, res);
            op.guardar();

        }
    }

    public boolean validar(){
        String error_radio;
        error_radio = getString(R.string.error_radio);

        if(radio_esfera.getText().toString().isEmpty()){
            radio_esfera.setError(error_radio);
            return false;
        }

        return true;
    }
    public void limpiar(View v){

        radio_esfera.setText("");
        resultado.setText("");
        radio_esfera.requestFocus();
    }
}
