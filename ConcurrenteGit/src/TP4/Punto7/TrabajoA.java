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
public class TrabajoA extends Trabajo implements Runnable{

    public TrabajoA(ImpresoraA imp, String texto, String color) {
        super(imp, texto, color);
    }
    
}
