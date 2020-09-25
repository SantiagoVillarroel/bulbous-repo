/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto6;

import TP3.Punto3.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseC implements Runnable {
    Variable i;
    int cant;
    public ClaseC(Variable i) {
        this.i=i;
    }

    public ClaseC(TP4.Punto6.Variable i, int cant) {
        this.i = i;
        this.cant = cant;
    }
    
    public void run(){
        int cantI= i.getValor();
        for(int x=0; x<= cantI;x++){
        i.imprimirC(cant);
    }}
    
    
}
