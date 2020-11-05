/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto14;

import TP4.Punto13.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Mozo extends Persona implements Runnable {

    public Mozo(String nombre, ConfiteriaPequeña confi, String color) {
        super(nombre, confi, color);
    }

    
    public void run(){
        try {
            this.confi.llevarBebidaAEmpleado(color);
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
