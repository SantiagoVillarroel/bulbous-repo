/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Hamster implements Runnable{
    
    private Instalacion[] inst;
    private String color;
    private AdminJaula aj;

    public Hamster(Instalacion[] i,String color,AdminJaula aj) {
        this.inst=i;
        this.color=color;
        this.aj= aj;
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep(400);
                aj.solicitarUso(color);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
}
