package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarVolumenCono extends AppCompatActivity {

    private EditText altura_cono, radio_cono;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_volumen_cono);
        altura_cono = findViewById(R.id.txtAlturaCono);
        radio_cono = findViewById(R.id.txtRadioCono);
        resultado = findViewById(R.id.lblResultadoVolumenCono);
        radio_cono.requestFocus();
    }

    public void calcular(View v){
        Double radio, altura, res;
        Operacion op;
        String msj_radio, msj_altura;


        if(validar()){

            radio = Double.parseDouble(radio_cono.getText().toString());
            altura = Double.parseDouble(altura_cono.getText().toString());
            res = 3.1416 * radio * radio * altura / 3;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_volumen_de_cono), getString(R.string.msj_altura)+altura+" "+getString(R.string.msj_radio)+radio, res);
            op.guardar();

        }
    }

    public boolean validar(){
        String  error_altura, error_radio;

        error_altura = getString(R.string.error_altura);
        error_radio = getString(R.string.error_radio);

        if(altura_cono.getText().toString().isEmpty()){
            altura_cono.setError(error_altura);
            altura_cono.requestFocus();
            return false;
        }
        else if (radio_cono.getText().toString().isEmpty()){
            radio_cono.setError(error_radio);
            radio_cono.requestFocus();
            return false;
        }


        return true;
    }

    public void limpiar(View v){

        altura_cono.setText("");
        radio_cono.setText("");
        resultado.setText("");
        radio_cono.requestFocus();
    }
}
