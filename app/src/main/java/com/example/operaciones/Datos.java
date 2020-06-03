package com.example.operaciones;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Operacion> operaciones = new ArrayList();

    public static void guardar(Operacion op){
        operaciones.add(op);
    }

    public static ArrayList<Operacion> Obtener(){
        return operaciones;
    }
}
