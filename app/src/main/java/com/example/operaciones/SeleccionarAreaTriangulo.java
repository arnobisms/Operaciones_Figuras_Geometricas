package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionarAreaTriangulo extends AppCompatActivity {

    private EditText base_triangulo, altura_triangulo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_area_triangulo);
        base_triangulo = findViewById(R.id.txtBaseTriangulo);
        altura_triangulo = findViewById(R.id.txtAlturaTriangulo);
        resultado = findViewById(R.id.lblResultadoAreaTriangulo);
        base_triangulo.requestFocus();
    }

    public void calcular(View v){
        Double base, altura, res;
        Operacion op;
        String msj_base, msj_altura;


        if(validar()){

            base = Double.parseDouble(base_triangulo.getText().toString());
            altura = Double.parseDouble(altura_triangulo.getText().toString());
            res = base * altura / 2;
            resultado.setText(""+ res);
            op = new Operacion(getString(R.string.msj_area_del_triangulo), getString(R.string.msj_base)+base+" "+getString(R.string.msj_altura)+altura, res);
            op.guardar();

        }
    }

    public boolean validar(){
        String error_base, error_altura;
        error_base = getString(R.string.error_base);
        error_altura = getString(R.string.error_altura);


        if(base_triangulo.getText().toString().isEmpty()){
            base_triangulo.setError(error_base);
            base_triangulo.requestFocus();
            return false;
        }
        else if (altura_triangulo.getText().toString().isEmpty()){
            altura_triangulo.setError(error_altura);
            altura_triangulo.requestFocus();
            return false;
        }


        return true;
    }

    public void limpiar(View v){

        base_triangulo.setText("");
        altura_triangulo.setText("");
        resultado.setText("");
        base_triangulo.requestFocus();
    }

}
