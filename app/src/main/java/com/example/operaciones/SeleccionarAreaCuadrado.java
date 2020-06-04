package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarAreaCuadrado extends AppCompatActivity {

    private EditText lado_cuadrado;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_area_cuadrado);
        lado_cuadrado = findViewById(R.id.txtLadoCuadrado);
        resultado =  findViewById(R.id.lblResultadoAreaCuadrado);
        lado_cuadrado.requestFocus();

    }

    public void calcular(View v){
        Double lado, res;
        Operacion op;
        String msj_lado;


        if(validar()){

            lado = Double.parseDouble(lado_cuadrado.getText().toString());
            res = lado * lado;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_area_del_cuadrado), getString(R.string.msj_lado)+lado, res);
            op.guardar();

        }
    }

    public boolean validar(){
        String error_lado;
        error_lado = getString(R.string.error_lado);

        if(lado_cuadrado.getText().toString().isEmpty()){
            lado_cuadrado.setError(error_lado);
            return false;
        }

        return true;
    }

    public void limpiar(View v){

        lado_cuadrado.setText("");
        resultado.setText("");
        lado_cuadrado.requestFocus();
    }

}
