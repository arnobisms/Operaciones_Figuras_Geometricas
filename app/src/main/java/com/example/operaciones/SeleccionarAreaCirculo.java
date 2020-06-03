package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarAreaCirculo extends AppCompatActivity {

    private EditText radio_circulo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_area_circulo);
        radio_circulo = findViewById(R.id.txtRadioCirculo);
        resultado = findViewById(R.id.lblResultadoAreaCirculo);
        radio_circulo.requestFocus();
    }


    public void calcular(View v){
        Double radio, res;
        Operacion op;

        if(validar()){

            radio = Double.parseDouble(radio_circulo.getText().toString());
            res = 3.1416 * radio * radio;
            resultado.setText(""+ res);

            op = new Operacion("Area del circulo", "Radio:"+radio, res);
            op.guardar();

        }
    }



    public boolean validar(){
        String error_radio;
        error_radio = getString(R.string.error_radio);

        if(radio_circulo.getText().toString().isEmpty()){
            radio_circulo.setError(error_radio);
            return false;
        }

        return true;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        radio_circulo.setText("");
        resultado.setText("");
        radio_circulo.requestFocus();
    }
}
