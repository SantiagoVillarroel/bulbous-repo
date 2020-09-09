/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class ClaseA implements Runnable{
    Variable i;

    public ClaseA(Variable i) {
        this.i = i;
    }
    public void run(){
        for(int x=0; x<=10; x++){
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClaseA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(i.getValor()==0){
            System.out.print("A");
            i.setValor(1);
        }}
    }
}
