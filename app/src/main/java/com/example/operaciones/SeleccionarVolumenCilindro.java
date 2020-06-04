package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarVolumenCilindro extends AppCompatActivity {

    private EditText altura_cilindro, radio_cilindro;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_volumen_cilindro);
        altura_cilindro = findViewById(R.id.txtAlturaCilindro);
        radio_cilindro = findViewById(R.id.txtRadioCilindro);
        resultado = findViewById(R.id.lblResultadoVolumenCilindro);
        altura_cilindro.requestFocus();
    }

    public void calcular(View v){
        Double radio, altura, res;
        Operacion op;
        String msj_radio, msj_altura;


        if(validar()){

            radio = Double.parseDouble(radio_cilindro.getText().toString());
            altura = Double.parseDouble(altura_cilindro.getText().toString());
            res = 3.1416 * radio * radio * altura;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_volumen_de_cilindro), getString(R.string.msj_altura)+altura+" "+getString(R.string.msj_radio)+radio, res);
            op.guardar();

        }
    }

    public boolean validar(){
        String  error_altura, error_radio;

        error_altura = getString(R.string.error_altura);
        error_radio = getString(R.string.error_radio);

        if(altura_cilindro.getText().toString().isEmpty()){
            altura_cilindro.setError(error_altura);
            altura_cilindro.requestFocus();
            return false;
        }
        else if (radio_cilindro.getText().toString().isEmpty()){
            radio_cilindro.setError(error_radio);
            radio_cilindro.requestFocus();
            return false;
        }


        return true;
    }


    public void limpiar(View v){

        altura_cilindro.setText("");
        radio_cilindro.setText("");
        resultado.setText("");
        altura_cilindro.requestFocus();
    }
}
