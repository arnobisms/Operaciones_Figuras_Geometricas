package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarVolumenCubo extends AppCompatActivity {

    private EditText lado_cubo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_volumen_cubo);
        lado_cubo = findViewById(R.id.txtLadoCubo);
        resultado =  findViewById(R.id.lblResultadoVolumenCubo);
        lado_cubo.requestFocus();
    }

    public void calcular(View v){
        Double lado, res;
        Operacion op;
        String msj_lado;


        if(validar()){

            lado = Double.parseDouble(lado_cubo.getText().toString());
            res = lado * lado * lado;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_volumen_de_cubo), getString(R.string.msj_lado)+lado, res);
            op.guardar();

        }
    }

    public boolean validar(){
        String error_lado;
        error_lado = getString(R.string.error_lado);

        if(lado_cubo.getText().toString().isEmpty()){
            lado_cubo.setError(error_lado);
            return false;
        }

        return true;
    }

    public void limpiar(View v){

        lado_cubo.setText("");
        resultado.setText("");
        lado_cubo.requestFocus();
    }

}
