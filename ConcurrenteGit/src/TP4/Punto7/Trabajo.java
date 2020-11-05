/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Trabajo implements Runnable {
    private Impresora imp;
    String texto;
    String color;

    public Trabajo(Impresora imp,String texto,String color) {
        this.imp = imp;
        this.texto = texto;
        this.color=color;
        
    }

    
    
    public void run(){
        imp.imprimir(color, texto);
        
    }

    public Trabajo(String texto) {
        this.texto = texto;
    }
    
}
