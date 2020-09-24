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
    public ClaseC(Variable i) {
        this.i=i;
    }
    public void run(){
        int cant= i.getValor();
        for(int x=0; x<= cant;x++){
        i.imprimirC();
    }}
    
    
}
