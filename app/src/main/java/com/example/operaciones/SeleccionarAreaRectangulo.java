package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarAreaRectangulo extends AppCompatActivity {

    private EditText base_rectangulo, altura_rectangulo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_area_rectangulo);
        base_rectangulo = findViewById(R.id.txtBaseRectangulo);
        altura_rectangulo = findViewById(R.id.txtAlturaRectangulo);
        resultado = findViewById(R.id.lblResultadoAreaRectangulo);
        base_rectangulo.requestFocus();
    }


    public void calcular(View v){
        Double base, altura, res;
        Operacion op;
        String msj_base, msj_altura;


        if(validar()){

            base = Double.parseDouble(base_rectangulo.getText().toString());
            altura = Double.parseDouble(altura_rectangulo.getText().toString());
            res = base * altura;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_area_del_rectangulo), getString(R.string.msj_base)+base+" "+getString(R.string.msj_altura)+altura, res);
            op.guardar();

        }
    }



    public boolean validar(){
        String error_base, error_altura;
        error_base = getString(R.string.error_base);
        error_altura = getString(R.string.error_altura);


        if(base_rectangulo.getText().toString().isEmpty()){
            base_rectangulo.setError(error_base);
            base_rectangulo.requestFocus();
            return false;
        }
        else if (altura_rectangulo.getText().toString().isEmpty()){
              altura_rectangulo.setError(error_altura);
              altura_rectangulo.requestFocus();
              return false;
             }


        return true;
    }

    public void limpiar(View v){

        base_rectangulo.setText("");
        altura_rectangulo.setText("");
        resultado.setText("");
        base_rectangulo.requestFocus();
    }


}
